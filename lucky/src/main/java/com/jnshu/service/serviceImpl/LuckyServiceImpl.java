package com.jnshu.service.serviceImpl;

import com.jnshu.dao.LuckyMapper;
import com.jnshu.pojo.Lucky;
import com.jnshu.service.LuckyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LuckyServiceImpl
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/30 2:01
 * @Version 1.0
 **/

@Service
public class LuckyServiceImpl implements LuckyService {

    @Autowired
    LuckyMapper luckyMapper;

    @Override
    public int selectCount() {
        return luckyMapper.selectCount();
    }

    @Override
    public Lucky selectRand() {
        return luckyMapper.selectRand();
    }

    @Override
    public List<Lucky> selectId() {
        return null;
    }

    @Override
    public Lucky selectByPrimaryKey(Long id) {
        return luckyMapper.selectByPrimaryKey(id);
    }
}
