package com.sccddw.test.service.impl;


import com.sccddw.test.dao.SensorDataRepository;
import com.sccddw.test.entity.db.MongoSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author dell
 * date 2020/10/18 15:02
 * @version 1.0
 **/
@Service
public class MongoSensorDataServiceImpl {
    @Autowired
    SensorDataRepository sensorDataRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    /**
     * 保存数据
     * @author zhangweijin
     * date 2020/10/18 15:19
     * @param sensorData
     * return
    **/
    public void save(MongoSensorData sensorData) {
        MongoSensorData s = sensorDataRepository.save(sensorData);
    }

    public void saveAll(List<MongoSensorData> list) {
        sensorDataRepository.saveAll(list);
    }

    public Page<MongoSensorData> pageFindByAcquisitionTime(String acquisitionTime , int current, int pageSize) {

        return sensorDataRepository.findByAcquisitionTimeContains(acquisitionTime, PageRequest.of(current, pageSize));
    }

    /**
     * 多集合联合查询
     * @author zhangweijin
     * date 2020/10/18 19:42
     * @param null
     * return
    **/
    public List<Map> lookupOperation(String acquisitionTime) {
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("mongoDevice"). //关联从表名
                localField("deviceCode"). //主表关联字段
                foreignField("deviceCode"). //从表关联的字段
                as("SensorDataAndDevice"); //查询结果表的别名

        // 匹配id条件
        MatchOperation matchOperation = new MatchOperation(Criteria.where("acquisitionTime").is(acquisitionTime));
        SortOperation sortOperation = new SortOperation(Sort.by(Sort.Order.desc("createTime")));
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation, matchOperation, sortOperation);
//        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        List<Map> res = mongoTemplate.aggregate(aggregation, "mongoSensorData", Map.class).getMappedResults();

        return res;
    }

}
