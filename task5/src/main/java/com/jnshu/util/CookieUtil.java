package com.jnshu.util;

import io.jsonwebtoken.Claims;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName CookieUtil
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/27 20:45
 * @Version 1.0
 **/
public class CookieUtil {
    public static void createCookie(HttpServletResponse response,
                                    String cookieName,
                                    String cookieValue,
                                    int sec,// cookie有效期时间
                                    String pathUrl) {

        // 设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        // 创建cookie对象
        Cookie cookie = new Cookie(cookieName, cookieValue);
        // 设置cookie有效期
        cookie.setMaxAge(sec);
        // 设置cookie有效路径
        cookie.setPath(pathUrl);
        // 响应cookie信息
        response.addCookie(cookie);
    }

    public static Cookie[] getCookie(HttpServletRequest request) throws UnsupportedEncodingException {
        // 设置编码格式
        request.setCharacterEncoding("UTF-8");
        // 获取请求信息
        Cookie[] cookies = request.getCookies();
        return cookies;
    }

    public static void deleteCookie(HttpServletResponse response, HttpServletRequest request, String cookieName) {
        cookieName = "token";
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            System.out.println("no cookie");
        }
        Cookie newCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                newCookie = new Cookie("token", cookie.getValue());
            }
        }
        newCookie.setMaxAge(0);
        newCookie.setPath(null);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.addCookie(newCookie);
    }

    public static String isLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                try {
                    Claims claims = JWTUtil.parseJWT(cookie.getValue());
                    String username = claims.getSubject();
                    return username;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        return null;
    }
}
