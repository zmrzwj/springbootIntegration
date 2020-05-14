package com.sccddw.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author dell
 * date 2020/5/11 10:42
 * @version 1.0
 **/
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public String get(String key) {
        String value = (String) stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    public void add(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public Object getObj(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean addObj(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
