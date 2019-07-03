/**
 * 方法实现说明
 *
 * @author 作者姓名
 * <p>
 * $param$
 * @return $return$
 * @exception $exception$
 * @date $date$ $time$
 */

import com.jnshu.dao.UserMapper;
import com.jnshu.pojo.User;
import com.jnshu.util.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/20 0:44
 * @Version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class Demo {

    private Logger log = LogManager.getLogger(Demo.class);

    @Autowired
    UserMapper userMapper;

    @Test
    public void MD5() {
        String name = "admin111";
        int i = userMapper.selectUser(name);
        if (i>0){
            System.out.println("用户名重复,请换个名字注册");
        }else {
            System.out.println("用户名可以使用");
            User user = new User();
            String ps = MD5Util.md5Hex("daohaodeshi250");
            user.setName(name);
            user.setPassword(ps);
            user.setDaily("www.baidu.com");
            user.setEmail("fdsjaklfd@qq.com");
            userMapper.insertSelective(user);
        }
    }
}
