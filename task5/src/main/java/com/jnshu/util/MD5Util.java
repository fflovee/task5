package com.jnshu.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

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
            System.out.println("========================");
            return new String(new Hex().encode(digest));
            // return ps;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.toString());
        }
        return "------------------生成MD5错误--------------------";
    }

    // 验证password通过MD5加密后和数据库中存的密码是否一致
    public static boolean verPassword(String password,String md5password) {
        return md5password.equals(md5Hex(password));
    }



/*    public static String getMD5(String password) {
        password = md5Hex(password);
        return password;
    }*/
}
