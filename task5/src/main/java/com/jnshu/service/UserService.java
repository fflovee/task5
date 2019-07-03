package com.jnshu.service;

import com.jnshu.pojo.User;

public interface UserService {

    User selectByPrimaryKey(Long id);

    User selectMailInDb(String mail);

    User selectNameInDb(String name);

    int insertSelective(User record);

    int selectUser(String name);

}
