package com.jnshu.service;

import com.jnshu.pojo.Excellence;
import com.jnshu.pojo.ExcellenceExample;

import java.util.List;

/**
 * @ClassName ExcellenceService
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/22 10:24
 * @Version 1.0
 **/


public interface ExcellenceService {

    List<Excellence> selectExcellenceExample(ExcellenceExample example);

}
