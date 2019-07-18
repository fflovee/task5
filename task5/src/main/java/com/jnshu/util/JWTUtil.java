package com.jnshu.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName JWTUtil 加密工具
 * @Description TODO
 * @Author 59200
 * @Date 2019/6/28 0:47
 * @Version 1.0
 **/

//@SuppressWarnings("unused")
public class JWTUtil {

    // 服务器的key,用于做加密的key数据,如果可以使用客户端生成的key,当前定义的常量可以不用
    private static final String JWT_SECERT = "test_jwt_secert";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static final int JWT_ERRORCODE_EXPIRE = 1005;// token过期
    public static final int JWT_ERRORCODE_FAIL = 1006;// 验证不通过

    public static SecretKey generalKey() {
        try {
            // byte[] encodeKey = Base64.decode(JWT_SECERT);
            // 不管用哪种方式最终得到一个byte[] 类型的key就行
            byte[] encodeKey = JWT_SECERT.getBytes("UTF-8");
            SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
            return key;
        } catch (UnsupportedEncodingException e) {// 不支持的字符编码
            e.printStackTrace();
        }
        return null;
    }

    public static String createJWT(String id, String iss, String subject, long ttMillis) {// iss:该jwt的签发者 // 对应controller里面传入的参数
        // 加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 当前时间
        long nowMillis = System.currentTimeMillis();
        // 当前时间和日期对象
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        // 创建JWT的构建语言,就是使用指定的信息和加密算法,生成token的工具
        JwtBuilder builder = Jwts.builder().setId(id).setIssuer(iss).setSubject(subject).setIssuedAt(now).signWith(signatureAlgorithm, secretKey);// 设置秘钥和算法
        if (ttMillis >= 0) {
            long expMillis = nowMillis + ttMillis;
            Date expDate = new Date(expMillis);//token失效时间
            // 设置有效期
            builder.setExpiration(expDate);
        }
        return builder.compact();// 生成token
    }

    public static JWTResult validateJWT(String jwtStr) {
        JWTResult checkResult = new JWTResult();
        Claims claims;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(JWT_ERRORCODE_EXPIRE);// token超时
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrCode(JWT_ERRORCODE_FAIL);// 校验失败
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(JWT_ERRORCODE_FAIL);// 其他异常
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody(); // getBody获取的就是token中记录的payload数据。就是payload中保存的所有的claims。
    }

    /**
     * 生成subject信息
     * @param subObj - 要转换的对象。
     * @return java对象->JSON字符串出错时返回null
     */
    public static String generalSubject(Object subObj) {
        try {
            return MAPPER.writeValueAsString(subObj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sign(Map<String, Object> payload, String key) {
        // Token默认过期时间10分钟(默认毫秒)
        Date expiration = new Date(System.currentTimeMillis() + 6000 * 1000);
        return Jwts.builder()
                .setClaims(payload)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();
    }

    public static Map verify(String token, String key) {
        try {
            return Jwts.parser()
                    .setSigningKey(key.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

}


