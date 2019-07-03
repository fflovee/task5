package com.jnshu.util;

import io.jsonwebtoken.Claims;

/**
 * @ClassName JWTResult
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/27 23:57
 * @Version 1.0
 **/
public class JWTResult {

    private int errCode;
    private boolean success;
    private Claims claims;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    @Override
    public String toString() {
        return "JWTResult{" +
                "errCode=" + errCode +
                ", success=" + success +
                ", claims=" + claims +
                '}';
    }
}
