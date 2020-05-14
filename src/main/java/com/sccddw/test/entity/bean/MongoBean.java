package com.sccddw.test.entity.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * description
 *
 * @author dell
 * date 2020/5/11 18:14
 * @version 1.0
 **/
@Data
@ToString
public class MongoBean {
    private String id;
    private String name;
    private String info;
    private Date createTime;

    public MongoBean(String id, String name, String info, Date createTime) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.createTime = createTime;
    }

//    @Override
//    public String toString() {
//        return "id=" + id + ",name=" + name + ",info=" + info + ",createTime" + createTime;
//    }
}
