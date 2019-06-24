package com.jnshu.service.serviceImpl;

import com.jnshu.dao.CompanyMapper;
import com.jnshu.pojo.Company;
import com.jnshu.pojo.CompanyExample;
import com.jnshu.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CompanyServiceImpl
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/23 1:52
 * @Version 1.0
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<Company> selectByCompany(CompanyExample example) {
        return companyMapper.selectByExample(example);
    }

    @Override
    public Company selectByPrimaryKey(Long id) {
        return companyMapper.selectByPrimaryKey(id);
    }
}
