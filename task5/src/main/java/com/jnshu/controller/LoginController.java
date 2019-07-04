package com.jnshu.controller;

import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import com.jnshu.util.CookieUtil;
import com.jnshu.util.JWTUtil;
import com.jnshu.util.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    private static Logger log = LogManager.getLogger(LoginController.class);

    @RequestMapping(value = "/a/login", method = RequestMethod.GET)
    public String loginView() {
        return "login";
    }

    // 登录功能
    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        try {
            // 验证用户名和账号密码不能为空
            if (null == username || "".equals(username) || null == password || "".equals(password)) {
                mav.addObject("code", -1);
                mav.addObject("msg", "账号密码不能为空");
                mav.setViewName("login");
                return mav;
            }

            // 从数据库中查出username
            User userInDb = userService.selectNameInDb(username);
            log.info("====================用户名为:====================" + userInDb);
            // 验证数据库中如果没有这个用户,则表示他没有注册,跳转到注册页面
            if (null == userInDb) {
                mav.addObject("code", -1);
                mav.addObject("msg", "账号不存在,请注册账号");
                mav.setViewName("register");
                return mav;
            }

            // 查询数据库中存的用户密码
            String passwordInDb = userInDb.getPassword();
            String id = userInDb.getId().toString();

            boolean pass = MD5Util.verPassword(password, passwordInDb);
            if (pass) {
                // 生成token
                String token = JWTUtil.createJWT(id, "task5_test", username, 36000);
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
            mav.addObject("msg", "error");
            mav.setViewName("login");
            return null;
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

    // 注册功能
    @RequestMapping(value = "/a/register", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    // 注册功能
    @RequestMapping(value = "/a/register", method = RequestMethod.POST)
    public ModelAndView register(String username, String password) {
        ModelAndView mav = new ModelAndView();
        // 验证用户名密码是否为空
        try {
            if (null == username || "".equals(username) || null == password || "".equals(password)) {
                mav.addObject("code", -1);
                mav.addObject("msg", "用户名不能为空");
                mav.setViewName("register");
                return mav;
            }
            // 验证用户名是否重复
            User userInDb = userService.selectNameInDb(username);
            if (null != userInDb) {
                mav.addObject("msg", "此用户名已注册");
                mav.setViewName("register");
                return mav;
            }
            String passwordMd5 = MD5Util.getSaltMD5(password);
            User user = new User();
            user.setName(username);
            user.setPassword(passwordMd5);
            user.setDaily("www.baidu.com");
            user.setEmail("fdsjaklfd@qq.com");
            userService.insertSelective(user);
            mav.addObject("msg", "注册成功,请登录");
            mav.setViewName("login");
            return mav;
        } catch (Exception e) {
            System.out.println(e);
            mav.addObject("code", -1);
            mav.addObject("msg", "error");
            mav.setViewName("register");
        }
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

}
