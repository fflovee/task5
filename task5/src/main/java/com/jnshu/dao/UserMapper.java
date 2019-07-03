package com.jnshu.dao;

import com.jnshu.pojo.User;
import com.jnshu.pojo.UserExample;

import java.util.List;

public interface UserMapper {

    int selectUser(String name);

    User selectUserName(String name);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}