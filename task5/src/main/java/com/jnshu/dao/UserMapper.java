package com.jnshu.dao;

import com.jnshu.pojo.User;
import com.jnshu.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User selectUser(String name);

    User selectByMobilEmail(@Param("mobile") String mobile,
                            @Param("email") String email);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}