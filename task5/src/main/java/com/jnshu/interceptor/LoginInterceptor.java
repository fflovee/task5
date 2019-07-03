package com.jnshu.interceptor;

import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import com.jnshu.util.CookieUtil;
import com.jnshu.util.JWTResult;
import com.jnshu.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName com.jnshu.interceptor.LoginInterceptor
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/27 4:18
 * @Version 1.0
 **/

public class LoginInterceptor extends HandlerInterceptorAdapter {
    Logger log = LogManager.getLogger(LoginInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {

        Cookie[] cookies = CookieUtil.getCookie(httpServletRequest);
        if (cookies == null) {
            httpServletResponse.sendRedirect("/a/login");
            return false;
        }
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            String token = cookie.getValue();
            if ("token".equals(cookieName)) {
                JWTResult result = JWTUtil.validateJWT(token);

                if (!result.isSuccess()) {
                    httpServletResponse.sendRedirect("/a/login");
                    return false;
                }

                Claims claims = result.getClaims();
                Long id = Long.valueOf(claims.getId()/*,60*60*1000*/);
                String username = claims.getSubject();

                User user = userService.selectByPrimaryKey(id);
                String password = user.getPassword();
                if (null != password) {
                    String newToken = JWTUtil.createJWT(claims.getId(), claims.getIssuer(), claims.getSubject(), 60 * 60 * 1000);
                    cookie.setValue(newToken);
                    return true;
                }

            }
        }
        System.out.println("preHandle(),在访问controller之前被调用");
        httpServletResponse.sendRedirect("/a/login");
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion(),在访问之后被调用");
    }
}
