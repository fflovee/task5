package com.jnshu.lucky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jnshu.dao")
public class LuckyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckyApplication.class, args);
    }

}
