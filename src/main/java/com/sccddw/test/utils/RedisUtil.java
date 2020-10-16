package com.sccddw.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * description
 *
 * @author dell
 * date 2020/5/11 10:42
 * @version 1.0
 **/
//@SuppressWarnings("unchecked")
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void add(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public Object getObj(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public void addObj(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSet(String key) {
        ArrayList<String> list = new ArrayList<String>();
        stringRedisTemplate.opsForSet().add("1", "2");
    }
}
