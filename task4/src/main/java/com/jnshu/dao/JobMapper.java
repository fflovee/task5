package com.jnshu.dao;

import com.jnshu.pojo.Job;
import com.jnshu.pojo.JobExample;
import java.util.List;

public interface JobMapper {

    List<JobExample> selectByExample(JobExample example);


    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}