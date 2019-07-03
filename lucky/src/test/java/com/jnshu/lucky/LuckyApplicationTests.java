package com.jnshu.lucky;

import com.jnshu.pojo.Lucky;
import com.jnshu.service.LuckyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.jnshu.dao")
@ComponentScan("com.jnshu")
public class LuckyApplicationTests {

    @Autowired
    LuckyService luckyService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void count() {
        int i = luckyService.selectCount();
        System.out.println("共有" + i + "条数据");
    }

    @Test
    public void rand() {
        Lucky lucky = luckyService.selectRand();
        System.out.println("who is the lucky dog?is " + lucky.getLuckyName());
    }

    @Test
    public void id() {
        List<Lucky> luckies = luckyService.selectId();
        System.out.println(luckies);
    }

    @Test
    public void num() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append(random.nextInt(999999999))
    }
}
