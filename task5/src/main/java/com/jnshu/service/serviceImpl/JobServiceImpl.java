package com.jnshu.service.serviceImpl;

import com.jnshu.dao.JobMapper;
import com.jnshu.pojo.JobExample;
import com.jnshu.redis.RedisUtil;
import com.jnshu.service.JobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
/*    @Autowired
    Memcached memcached;*/
    @Autowired
    RedisUtil redisUtil;

    private static Logger log = LogManager.getLogger(JobServiceImpl.class);

    @Override
    public List<JobExample> selectJobExample(JobExample example) {
        // memcached方法
/*
        if (memcached.getObject("joblist") != null) {
            log.info("从缓存获取joblist");
            log.info(memcached.getObject("joblist"));
            System.out.println(memcached.getObject("joblist"));
            return (List<JobExample>) memcached.getObject("joblist");
        }
        log.info("从数据库中获得joblist");
        List<JobExample> list = jobMapper.selectByExample(example);
        log.info("把joblist 写入缓存");
        memcached.setMemcachedClient("joblist", list);
        log.info("获得缓存" + memcached.getObject("joblist"));
        return list;
*/

        // redis方法
        if (redisUtil.get("joblist") != null) {
//            log.info("[redis]从缓存获取joblist \n");
//            log.info(redisUtil.get("joblist"));
//            System.out.println("[反序列化]"+redisUtil.get("joblist"));
            return (List<JobExample>) redisUtil.get("joblist");
        }
        log.info("[redis]从数据库中获得joblist");
        List<JobExample> list = jobMapper.selectByExample(example);
        log.info("[redis]把joblist 写入缓存");
        redisUtil.set("joblist", list);
//        log.info("[redis]获得缓存" + redisUtil.get("joblist"));
        return list;
    }
}
