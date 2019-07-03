package com.jnshu.service.serviceImpl;

import com.jnshu.dao.ExcellenceMapper;
import com.jnshu.pojo.Excellence;
import com.jnshu.pojo.ExcellenceExample;
import com.jnshu.service.ExcellenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExcellenceServiceImpl
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/22 10:27
 * @Version 1.0
 **/

@Service
public class ExcellenceServiceImpl implements ExcellenceService {

    @Autowired
    ExcellenceMapper excellenceMapper;

    @Override
    public List<Excellence> selectExcellenceExample(ExcellenceExample example) {
        return excellenceMapper.selectByExample(example);
    }
}
