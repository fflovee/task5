package com.jnshu.dao;

import com.jnshu.pojo.Company;
import com.jnshu.pojo.CompanyExample;
import java.util.List;

public interface CompanyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample company);

    Company selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

}