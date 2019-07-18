package com.jnshu.util;

import java.util.Random;

/**
 * @ClassName NumRandom
 * @Description TODO
 * @Author 59200
 * @Date 2019/7/10 1:55
 * @Version 1.0
 **/
public class NumRandom {

    public static String randomNum() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        return result;
    }
}
