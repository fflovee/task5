package com.jnshu.dao;

import com.jnshu.pojo.Excellence;
import com.jnshu.pojo.ExcellenceExample;
import java.util.List;

public interface ExcellenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Excellence record);

    int insertSelective(Excellence record);

    List<Excellence> selectByExample(ExcellenceExample example);

    Excellence selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Excellence record);

    int updateByPrimaryKey(Excellence record);
}