package com.sccddw.test.utils;

import com.sccddw.test.entity.bean.MongoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/5/11 18:36
 * @version 1.0
 **/
@Component
public class MongoUtil {
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     *
     * @author zhangweijin
     * date 2020/5/11 18:49
     * @param obj
     * return boolean
    **/
    public boolean saveObj(Object obj) {
        try {
            mongoTemplate.save(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object getObjById (String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, MongoBean.class);
    }

    public List<MongoBean> findAll () {
        List<MongoBean> list = new ArrayList<>();
        try {
            return mongoTemplate.findAll(MongoBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
    }
}

