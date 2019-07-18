package com.jnshu.service;

import com.jnshu.pojo.User;

public interface UserService {

    User selectByPrimaryKey(Long id);

    User selectUserNameInDb(String name);

    User selectByMobileEmail(String mobile,String email);

    int insertSelective(User record);

}
