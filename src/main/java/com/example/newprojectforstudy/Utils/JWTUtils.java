package com.example.newprojectforstudy.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JWTUtils {
    /** 过期期限（1天） */
    private static final long TIME_OUT = 1000 * 60 * 60 * 24;

    /** 密钥 */
    private static final String secret = "@#$$$%%%%";

    public static String makeSignTure(Map<String, String> playLoad) {
        final Date date = new Date(System.currentTimeMillis() + TIME_OUT);
        JWTCreator.Builder builder = JWT.create();
        // playLoad
        playLoad.forEach((k,y)->{
            builder.withClaim(k, y);
        });
        // 过期期限
        String token = builder.withExpiresAt(date)
                // 验签算法设置，生成签名
                .sign(Algorithm.HMAC256(secret)); //

        return token;
    }

    public static void assertWithHMAC256(String token){
        JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }

    public static String getPlayload(String token,String name){
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token).getClaim(name).asString();
    }
}
