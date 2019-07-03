package com.jnshu.service.serviceImpl;

import com.jnshu.dao.UserMapper;
import com.jnshu.pojo.User;
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

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectMailInDb(String mail) {
        return null;
    }

    @Override
    public User selectNameInDb(String name) {
        return userMapper.selectUserName(name);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int selectUser(String name) {
        return userMapper.selectUser(name);
    }
}
