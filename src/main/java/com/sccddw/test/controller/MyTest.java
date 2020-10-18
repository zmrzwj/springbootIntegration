package com.sccddw.test.controller;

import com.sccddw.test.entity.bean.MongoBean;
import com.sccddw.test.entity.bean.RedisBean;
import com.sccddw.test.entity.db.MongoSensorData;
import com.sccddw.test.entity.db.SensorData;
import com.sccddw.test.service.impl.MongoSensorDataServiceImpl;
import com.sccddw.test.utils.MongoUtil;
import com.sccddw.test.utils.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/9/2 13:50
 * @version 1.0
 **/
@RestController
public class MyTest {
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    MongoUtil mongoUtil;

    @Autowired
    MongoSensorDataServiceImpl mongoSensorDataService;



    @GetMapping("/mongoTest")
    @ApiOperation(value="我的测试 AllocateDepotOrderDetail")
    public String mongoTest() {
//        MongoBean mongoBean = new MongoBean("567", "zwj", "你好呀", new Date());
//        mongoUtil.saveObj(mongoBean);
//
//        List list =  mongoUtil.findAll();
//
//        System.out.println("===============================");
//
//        Object mongoObj = mongoUtil.getObjById("123");
//        System.out.println(mongoObj);
        MongoSensorData sensorData = new MongoSensorData();
        sensorData.setDeviceCode("H01000001");
        sensorData.setAcquisitionTime("2020-10-11 12:11:11");
        mongoSensorDataService.save(sensorData);

        return "hello";
    }

    @GetMapping("/redisTest")
    @ApiOperation(value="我的测试 AllocateDepotOrderDetail")
    public Object redisTest(@RequestParam("value")String value) {
        RedisBean redisBean = new RedisBean("zwj", 28);
        String key = "20200511";
        redisUtil.add(key, value);
        String redisValue = redisUtil.get(key);

        redisUtil.addObj(key, redisBean);

        Object cacheRedisBean = redisUtil.getObj(key);
        System.out.println(cacheRedisBean);
        return cacheRedisBean;
    }



    @GetMapping("/esTest")
    @ApiOperation(value="我的测试 AllocateDepotOrderDetail")
    public String EsTest(@RequestParam("value")String value) {
//        boolean bool = esUtil.existsIndex("es_test");
//        System.out.println("======");
//        System.out.println(bool);
        return "es test";
    }
}
