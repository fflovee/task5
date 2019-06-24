package com.jnshu.service;

import com.jnshu.pojo.Company;
import com.jnshu.pojo.CompanyExample;

import java.util.List;

public interface CompanyService {

    List<Company> selectByCompany(CompanyExample example);

    Company selectByPrimaryKey(Long id);

}
