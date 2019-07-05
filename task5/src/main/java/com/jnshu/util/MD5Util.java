package com.jnshu.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @ClassName MD5Util
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/28 11:31
 * @Version 1.0
 **/
public class MD5Util {

    /*@SuppressWarnings("unused")// 抑制没有被使用过的代码警告*/
    public static String md5Hex(String str) {
        try {
            // 获取md实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 生成摘要
            byte[] digest = md.digest(str.getBytes());
            // org.apache.commons.codec包的Hex.encodeHexString（Byte[] bytes）可将byte[]转为16进制字符串
            // int a=1/0;
            // String ps = new String(new Hex().encode(digest));
            System.out.println("============生成MD5============");
            return new String(new Hex().encode(digest));
            // return ps;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.toString());
        }
        return "------------------生成MD5错误--------------------";
    }

    public static String getSaltMD5(String password) {
        //生成一个16位的随机数:
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append(random.nextInt(99999999)).append(99999999);
        int len = stringBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                stringBuilder.append("0");
            }
        }
        String salt = stringBuilder.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }

        return String.valueOf(cs);
    }

    // 验证password通过MD5加密后和数据库中存的密码是否一致
    public static boolean verPassword(String password, String md5password) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5password.charAt(i);
            cs2[i / 3] = md5password.charAt(i + 1);
            cs1[i / 3 * 2 + 1] = md5password.charAt(i + 2);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(String.valueOf(cs1));
    }



/*    public static String getMD5(String password) {
        password = md5Hex(password);
        return password;
    }*/
}
