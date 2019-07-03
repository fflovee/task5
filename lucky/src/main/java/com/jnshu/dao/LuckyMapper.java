package com.jnshu.dao;

import com.jnshu.pojo.Lucky;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LuckyMapper {

    Integer selectCount();

    Lucky selectRand();

    Lucky selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int insert(Lucky record);

    int insertSelective(Lucky record);

    int updateByPrimaryKeySelective(Lucky record);

    int updateByPrimaryKey(Lucky record);
}