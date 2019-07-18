package com.jnshu.controller;

import com.aliyuncs.exceptions.ClientException;
import com.jnshu.aliyun.QuerySendDetails;
import com.jnshu.pojo.User;
import com.jnshu.redis.RedisUtil;
import com.jnshu.service.UserService;
import com.jnshu.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/29 16:07
 * @Version 1.0
 **/

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    private static Logger log = LogManager.getLogger(LoginController.class);

    @RequestMapping(value = "/a/login", method = RequestMethod.GET)
    public String loginView() {
        return "login";
    }

    // 转向注册功能
    @RequestMapping(value = "/a/register", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    // 登录功能
    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public ModelAndView login(String phoneNum, String password, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            // 验证用户名和账号密码不能为空
            if (null == phoneNum || "".equals(phoneNum) || null == password || "".equals(password)) {
                mav.addObject("code", -1);
                mav.addObject("msg", "账号密码不能为空");
                mav.setViewName("login");
                return mav;
            }

            // 从数据库中查出username
            String mobile = null;
            String email = null;
            if (CheckUtil.isMobileNO(phoneNum)) {
                mobile = phoneNum;
            }
            if (CheckUtil.isEmail(phoneNum)) {
                email = phoneNum;
            }
            User userInDb = userService.selectByMobileEmail(mobile, email);
            log.info("====================用户名为:====================" + userInDb);
            // 验证数据库中如果没有这个用户,则表示他没有注册,跳转到注册页面
            if (null == userInDb) {
                mav.addObject("msg", "账号不存在,请注册账号");
                log.info("用户不存在,需要注册");
                mav.setViewName("register");
                return mav;
            }

            // 从数据库中查出phone_number
/*            Long userMobileInDb = userService.selectMobileInDb(phoneNum);
            log.info("数据库中的电话号码为" + phoneNum);
            if (null == userMobileInDb) {
                mav.addObject("code", -1);
                mav.addObject("msg", "账号不存在,请注册账号");
                log.info("电话不存在,需要注册");
                mav.setViewName("register");
                return mav;
            }*/

            // 查询数据库中存的用户密码
            String passwordInDb = userInDb.getPassword();
            String id = userInDb.getId().toString();

            boolean pass = MD5Util.verPassword(password, passwordInDb);
            if (pass) {
                // 生成token
                String token = JWTUtil.createJWT(id, "task5_test", phoneNum, 36000);
                // 创建cookie
                CookieUtil.createCookie(response, "token", token, 3600, null);
                String name = userInDb.getName();
                mav.addObject("name", name);
                mav.addObject("code", 200);
                mav.addObject("msg", "登录成功");
                mav.setViewName("vip");
                return mav;
            }
            mav.addObject("code", -1);
            mav.addObject("msg", "账号密码错误");
            mav.setViewName("login");
            return mav;
        } catch (Exception e) {
            mav.addObject("code", -1);
            mav.addObject("msg", "未知错误:1001");
            mav.setViewName("login");
            return mav;
        }
    }

    // 登录后转发到vip页面
    @RequestMapping(value = "/a/u/vip")
    public ModelAndView toVip(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("vip");
        String name = (null != CookieUtil.isLogin(request) ? CookieUtil.isLogin(request) : null);
        mav.addObject("name", name);
        return mav;
    }

    /**
     * @param username
     * @param password
     * @param phoneNum
     * @param code
     * @return
     */
    // 注册功能
    @RequestMapping(value = "/a/register", method = RequestMethod.POST)
    public ModelAndView register(String username, String password, String phoneNum, String code) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("mobile", phoneNum);
        // 验证码是否正确
        String codeKey = phoneNum + "tactics";
        String codeInRedis = (String) redisUtil.get(codeKey);
        if (!code.equals(codeInRedis)) {
            mav.addObject("msg", "验证码错误");
            mav.addObject("username", username);
            mav.addObject("mobile", phoneNum);
            mav.setViewName("register");
            return mav;
        }

        // 判断是否为手机号或者邮箱号
        if (!CheckUtil.isMobileNO(phoneNum) && !CheckUtil.isEmail(phoneNum)) {
            log.info("不符合手机或者邮箱格式");
            mav.addObject("code", -1);
            mav.addObject("msg", "请输入正确的手机号");
            mav.setViewName("register");
            return mav;
        }

        // 创建mobile email 默认null
        String mobile = null;
        String email = null;

        if (CheckUtil.isEmail(phoneNum)) {
            email = phoneNum;
        }
        if (CheckUtil.isMobileNO(phoneNum)) {
            mobile = phoneNum;
        }

        // 验证手机号,邮箱是否注册过
        User user = new User();
        User userMobileEmailInDb = userService.selectByMobileEmail(mobile, email);
        if (null != userMobileEmailInDb) {
            mav.addObject("msg", "此用户已注册");
            mav.setViewName("register");
            return mav;
        }

        // 验证用户名密码是否为空
        if (null == username || "".equals(username) || null == password || "".equals(password)) {
            mav.addObject("code", -1);
            mav.addObject("msg", "用户名不能为空");
            mav.setViewName("register");
            return mav;
        }

//        User user = new User();
        String passwordMd5 = MD5Util.getSaltMD5(password);
        user.setName(username);
        user.setMobile(mobile);
        user.setPassword(passwordMd5);
        user.setDaily("www.baidu.com");
        user.setEmail(email);
        System.out.println(user);
        userService.insertSelective(user);
        mav.addObject("msg", "注册成功,请登录");
        mav.setViewName("login");
        return mav;
    }

    // 登出功能
    @RequestMapping(value = "/a/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        String cookieName = "token";
        CookieUtil.deleteCookie(response, request, cookieName);
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:login";

    }

    // 短信(邮箱)服务
    @RequestMapping(value = "/a/sendSms", method = RequestMethod.POST)
    public ModelAndView sendMsg(String phoneNum) throws IOException, ClientException {

        ModelAndView mav = new ModelAndView();

        // 正则判断是否是正确的手机号
        if (!CheckUtil.isMobileNO(phoneNum) && !CheckUtil.isEmail(phoneNum)) {
            log.info("[log]:电话号码或者邮箱为:" + phoneNum);
            mav.addObject("mobile_msg", "请输入正确的邮箱或者手机号");
            log.info("[log]:手机号或者邮箱格式不正确");
            mav.addObject("mobile", phoneNum);
            mav.setViewName("register");
            return mav;
        }


        // 初始化时间
        long lastSendTime = 0;
        // 初始化次数
        int sendCount = 0;


        if (null != redisUtil.hget(phoneNum, "lastSendTime")) {
            // 如果redis中存在上次发送时间,获取上次发送时间
            lastSendTime = (long) redisUtil.hget(phoneNum, "lastSendTime");
            // 如果redis中存在上次发送次数,获取上次发送次数
            sendCount = (int) redisUtil.hget(phoneNum, "sendCount");
        }
        log.info("缓存发送时间" + lastSendTime);
        log.info("缓存发送次数" + sendCount);

        // 打出当前时间的时间戳
        long now = System.currentTimeMillis();

        // 判断发送次数,如果超过三次就不能发送
        if (3 <= sendCount) {
            log.info("超过发送次数,发送次数为===>" + sendCount);
            mav.addObject("msg", "已经超过今日发送上限");
            mav.setViewName("register");
            return mav;
        }

        // 判断时间是否小于60s
        if ((now - lastSendTime) < 1000 * 60) {
            mav.addObject("msg", "请求过于频繁,请稍等");
            mav.setViewName("register");
            log.info("距离下次发送验证码时间还有" + (60 - (now - lastSendTime) / 1000 + "秒"));
            return mav;
        }

        // 初始化手机和邮箱参数
        String mobile = null;
        String email = null;

        // 判断是否为手机号
        if (CheckUtil.isMobileNO(phoneNum)) {
            mobile = phoneNum;
        }
        // 判断是否为邮箱
        if (CheckUtil.isEmail(phoneNum)) {
            email = phoneNum;
        }
        // 验证手机号,邮箱是否注册过
        User userMobileEmailInDb = userService.selectByMobileEmail(mobile, email);
        System.out.println("======================" + userMobileEmailInDb);
        if (null != userMobileEmailInDb) {
            log.info("此手机/邮箱已注册");
            mav.addObject("msg", "此手机和邮箱已注册");
            mav.setViewName("register");
            return mav;
        }

        // 生成随机code
        String code = NumRandom.randomNum();

        // 发送短信是否发送成功
        // 调用aliSms方法(mobile,code)
        if (null != mobile) {
            if (QuerySendDetails.sendSms(mobile, code)) {
//            if (true) {
                // 存放本次发送成功时间戳,hashset方法,key,item,value 键 项 值
                redisUtil.hset(mobile, "lastSendTime", now);
                log.info("==========" + mobile, now);
                // 存放本次发送成功次数
                redisUtil.hset(mobile, "sendCount", sendCount + 1);
                // 判断当前是否有有效期
                if (0 >= redisUtil.getExpire(mobile)) {
                    // time(秒) 1分钟发送一次 time要大于0 如果time小于等于0 将设置无限期
                    // 指定缓存失效时间
                    redisUtil.expire(mobile, 60);
                    log.info("==========" + redisUtil.getExpire(phoneNum));
                }
                // 避免与发送次数同名添加策略字符串
                String codekey = mobile + "tactics";
                // time(秒) time要大于0 如果time小于等于0 将设置无限期
                // 设置失效时间1小时
                redisUtil.set(codekey, code, 60 * 60);
                log.info("===================" + codekey, code);
                mav.addObject("msg", "OK");
                System.out.println("OK");
                mav.addObject("mobile", mobile);
                mav.setViewName("register");
                return mav;
            }
        }
        if (null != email) {
            if (SendEmail.send_common(email, code)) {
                // 存放本次发送成功时间戳,hashset方法,key,item,value 键 项 值
                redisUtil.hset(email, "lastSendTime", now);
                log.info("==========" + email, now);
                // 存放本次发送成功次数
                redisUtil.hset(email, "sendCount", sendCount + 1);
                // 判断当前是否有有效期
                if (0 >= redisUtil.getExpire(email)) {
                    // time(秒) 1分钟发送一次 time要大于0 如果time小于等于0 将设置无限期
                    // 指定缓存失效时间
                    redisUtil.expire(email, 60);
                    log.info("==========" + redisUtil.getExpire(email));
                }
                // 避免与发送次数同名添加策略字符串
                String codekey = email + "tactics";
                // time(秒) time要大于0 如果time小于等于0 将设置无限期
                // 设置失效时间1小时
                redisUtil.set(codekey, code, 60 * 60);
                log.info("===================" + codekey, code);
                mav.addObject("msg", "OK");
                System.out.println("OK");
                mav.addObject("mobile", email);
                mav.setViewName("register");
                return mav;
            }
        }
        mav.setViewName("register");
        mav.addObject("mobile", phoneNum);
        mav.addObject("msg", "验证码发送失败");
        System.out.println("验证码发送失败");
        return mav;
    }

    @RequestMapping(value = "/a/upload", method = RequestMethod.POST)
    public ModelAndView upload(MultipartFile file) throws IOException {
        log.info(file.getName());
        ModelAndView mav = new ModelAndView();
        String urlPath = FileUpload.aliOss(file);
        mav.addObject("urlPath", urlPath);
        mav.setViewName("vip");
        return mav;
    }

    @RequestMapping("/a/upload")
    public ModelAndView upload() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("upload");
        return mav;
    }
}
