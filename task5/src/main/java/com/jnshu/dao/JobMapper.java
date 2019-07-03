package com.jnshu.dao;

import com.jnshu.pojo.Job;
import com.jnshu.pojo.JobExample;
import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    List<JobExample> selectByExample(JobExample example);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}