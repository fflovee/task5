import com.aliyuncs.exceptions.ClientException;
import com.jnshu.aliyun.QuerySendDetails;
import com.jnshu.dao.UserMapper;
import com.jnshu.redis.RedisUtil;
import com.jnshu.util.CheckUtil;
import com.jnshu.util.JWTUtil;
import com.jnshu.util.MD5Util;
import com.jnshu.util.NumRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/20 0:44
 * @Version 1.0
 **/

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")*/


public class Demotest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");

    private Logger log = LogManager.getLogger(Demotest.class);

//    @Autowired
//    RedisUtil redisUtil;


    UserMapper userMapper = applicationContext.getBean(UserMapper.class);

/*    @Test
    public void MD5() {
        String name = "admin111";
        int i = userMapper.selectUser(name);
        if (i > 0) {
            System.out.println("用户名重复,请换个名字注册");
        } else {
            System.out.println("用户名可以使用");
            User user = new User();
            String ps = MD5Util.md5Hex("daohaodeshi250");
            user.setName(name);
            user.setPassword(ps);
            user.setDaily("www.baidu.co");
            user.setEmail("fdsjaklfd@qq.com");
            userMapper.insertSelective(user);
        }
    }*/

    @Test
    public void md5num() {
        String password = "niaho";
        Random random = new Random();
        // 构造一个字符串生成器，其中没有字符，初始容量为16个字符。
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        System.out.println("随机的数字串为:" + stringBuilder);
        int len = stringBuilder.length();// length获取长度
        System.out.println("随机数的数字长度为:" + len);
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                stringBuilder.append("0");
            }
        }
        System.out.println("补0后的数字串为:" + stringBuilder);
        String salt = stringBuilder.toString();
        password = MD5Util.md5Hex(password + salt);
        System.out.println("MD5加密后的密码为:" + password);
        char[] cs = new char[48];
        System.out.println(cs);
        for (int i = 0; i < 48; i += 3) {
            //password 0.2.4.6.8.10
            cs[i] = password.charAt(i / 3 * 2);
            //salt 0.1.3.5.7.9
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        System.out.println("48位密码为:" + String.valueOf(cs));
    }

    @Test
    public void jwt() {
        Map user = new HashMap();
        user.put("zhangsan", "123");
        String jwt = JWTUtil.sign(user, "123");
        System.out.println(jwt);
        Map use = JWTUtil.verify(jwt, "123");
        System.out.println(use);
    }

    @Test
    public void StringTest() {
        String a = "aa" + "bb" + "cc";
        System.out.println(a);
    }

    @Test
    public void next() {
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int result = random.nextInt(10);
            System.out.println(result);
        }
    }

    @Test
    public void nnum() {
        String code = NumRandom.randomNum();
        System.out.println(code);
    }

    @Test
    public void mulsfjda() {
        String mobile = "13838341783";
        if (!CheckUtil.isMobileNO(mobile)) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }


    @Test
    public void sendMsm() throws ClientException {
        String code = NumRandom.randomNum();
        String phoneNum = "13838341783";
        QuerySendDetails.sendSms(phoneNum, code);
    }

    @Test
    public void test01() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        RedisUtil redisUtil = applicationContext.getBean(RedisUtil.class);
//        redisTemplate.opsForHash().put("haha", "time", System.currentTimeMillis());
        redisUtil.hset("haha", "time", System.currentTimeMillis());
        System.out.println(redisUtil.hget("haha","time"));
        redisUtil.hset("haha","age",123);
        System.out.println(redisUtil.hget("haha","age"));
//        Object time = redisUtil.hget("haha", "time");
//        Integer age= (Integer) redisUtil.hget("haha","age");
//        System.out.println(time);
//        System.out.println(age);
    }
}
