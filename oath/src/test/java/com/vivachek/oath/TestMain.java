package com.vivachek.oath;

import com.vivachek.core.domain.jwt.JwtDomain;
import com.vivachek.core.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.webresources.JarWarResource;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 15:50
 */
public class TestMain {
    @Test
    public void test1(){
        JwtBuilder builder = Jwts.builder()
                .setId("1")   //用户Id
                .setIssuedAt(new Date())  //用户登录的日期
                .setSubject("陈加兵")//用户名
                .setExpiration(new Date(new Date().getTime()+100000000))
                .claim("name", "陈加兵")
                .claim("age", 22)
                .signWith(SignatureAlgorithm.HS384, "sercet111111");  //指定签名的算法和秘钥（盐）
        String token = builder.compact();  //获取生成的token
        System.out.println(token);
    }

    @Test
    public void test2(){
        String key="sercet111111";
        JwtDomain domain = JwtDomain.builder()
                .expireAt(new Date(new Date().getTime()+1000*30*60))
                .issAt(new Date())
                .sub("1")
                .secret(key)
                .jti(UUID.randomUUID().toString())
                .build();
        String json = JwtUtils.createJWT(domain);
        System.out.println(json);
    }

    @Test
    public void test3(){
        String key="sercet111111";
        String json = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5YWM1YTBlNy05ODA1LTRiZGQtYjA2My04ZjZmYTIwNzM4Y2UiLCJpYXQiOjE1ODM3NDUzMzYsInN1YiI6IjEiLCJleHAiOjE1ODM3NDcxMzZ9.G2oLB9-vjF8V7jV3lqJ3Qoh5_5in--zyJ4s9rrmO3Mc";
        JwtDomain domain = JwtUtils.parse(json, key);
        System.out.println(domain);
    }
}