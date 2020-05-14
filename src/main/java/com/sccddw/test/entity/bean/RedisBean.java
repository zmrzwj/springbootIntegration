package com.sccddw.test.entity.bean;


import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @author dell
 * date 2020/5/11 16:33
 * @version 1.0
 **/
@Data
public class RedisBean  {
    String name;
    Integer age;

    public RedisBean() { } // 这是必须的

    public RedisBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
