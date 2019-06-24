package com.jnshu.service.serviceImpl;

import com.jnshu.dao.JobMapper;
import com.jnshu.pojo.JobExample;
import com.jnshu.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName JobServiceImpl
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/23 1:53
 * @Version 1.0
 **/
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobMapper jobMapper;

    @Override
    public List<JobExample> selectJobExample(JobExample example) {
        return jobMapper.selectByExample(example);
    }
}
