package com.myj.shopping.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JWTUtil {


    // 密钥
    private static SecretKey signKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 过期时间
    private static Long expire = 1800000L; // 30分钟

    /**
     * 生成JWT
     * @param claims JWT第二部分负载payload中存储的内容
     * @return
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder().signWith(signKey, SignatureAlgorithm.HS256)
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + expire))
                .compact();

        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}