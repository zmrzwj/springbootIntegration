package com.sccddw.test.utils;

import com.sccddw.test.config.CommonException;
import com.sccddw.test.entity.bean.ResultCode;
import com.sccddw.test.entity.db.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author dell
 * date 2020/5/8 15:15
 * @version 1.0
 **/
public class JwtUtil {
    public static final String SECRET = "ThisIsASecret";


    /**
     * @Param [user]
     * @Description //生成token
     * @exception
     * @return java.lang.String
     * @Author zhangyiwei
     * @Date 14:38 2019/7/1
     **/
    public static HashMap generateToken(User user) {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("username", user.getUsername());//you can put any data in the map
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 1000 hour
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        Date expiration = Jwts.claims().getExpiration();
        HashMap<String, Object> mapResult = new HashMap<>(16);
        mapResult.put("token","Bearer "+jwt);
        mapResult.put("expiration",(new Date(System.currentTimeMillis() + 3600_000_000L).getTime()));
        return mapResult;
        //return "Bearer "+jwt; //jwt前面一般都会加Bearer
    }

    /**
     * @Param [token]
     * @Description //验证token
     * @exception
     * @return void
     * @Author zhangyiwei
     * @Date 14:38 2019/7/1
     **/
    public static void validateToken(String token) {
        try {
            Map<String, Object> body = Jwts.parser()// parse the token.
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ",""))
                    .getBody();
        }catch (Exception e){
            throw new IllegalStateException("Invalid Token. "+e.getMessage());
        }
    }

    /**
     * @Param [token]
     * @Description //token 获取用户名
     * @exception
     * @return java.lang.String
     * @Author zhangyiwei
     * @Date 14:39 2019/7/1
     **/
    public static String returName(String token){
        try {
            Claims claims = Jwts.parser() //得到DefaultJwtParser
                    .setSigningKey(SECRET)         //设置签名的秘钥
                    .parseClaimsJws(token.replace("Bearer ","")).getBody();//设置需要解析的jwt
            String username = (String) claims.get("username");
            return username;
        }catch (Exception e){
            throw new CommonException(ResultCode.JWT_ERRCODE_NULL);//签名不存在
        }
    }
}
