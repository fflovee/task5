package com.jnshu.service;

import com.jnshu.pojo.Lucky;

import java.util.List;

/**
 * @ClassName luckyservice
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/30 2:00
 * @Version 1.0
 **/
public interface LuckyService {

    int selectCount();

    Lucky selectRand();

    List<Lucky> selectId();

    Lucky selectByPrimaryKey(Long id);

}
