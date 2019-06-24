package com.jnshu.service;

import com.jnshu.pojo.JobExample;

import java.util.List;

public interface JobService {

    List<JobExample> selectJobExample(JobExample example);

}
