package com.jnshu.service.serviceImpl;

import com.jnshu.dao.UserMapper;
import com.jnshu.pojo.User;
import com.jnshu.redis.RedisUtil;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/28 22:33
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectUserNameInDb(String name) {
        return userMapper.selectUser(name);
    }

    @Override
    public User selectByMobileEmail(String mobile, String email) {
        String key = null;
        if (null != mobile) {
            key = "user" + mobile;
        }
        if (null != email) {
            key = "user" + email;
        }
        if (redisUtil.get(key) != null) {
            return (User) redisUtil.get(key);
        }
        User user = userMapper.selectByMobilEmail(mobile,email);
        redisUtil.set(key,user);
        return user;
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }
}
