package com.jnshu.service.serviceImpl;

import com.jnshu.dao.CompanyMapper;
import com.jnshu.memcached.Memcached;
import com.jnshu.pojo.Company;
import com.jnshu.pojo.CompanyExample;
import com.jnshu.service.CompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Set;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;
    @Resource
    Memcached memcached;

    private static Logger log = LogManager.getLogger(CompanyServiceImpl.class);

    @Override
    public List<Company> selectByCompany(CompanyExample example) {
        // memcached方法
        if (memcached.getObject("companylist") != null) {
            log.info("获得缓存companylist");
            return (List<Company>) memcached.getObject("companylist");
        }
        log.info("获得数据库companylist数据");
        List<Company> list = companyMapper.selectByExample(example);
        memcached.setMemcachedClient("companylist", list);
        log.info("更新缓存companylist数据");
        return list;
    }

    @Override
    public Company selectByPrimaryKey(Long id) {
        return companyMapper.selectByPrimaryKey(id);
    }
}
