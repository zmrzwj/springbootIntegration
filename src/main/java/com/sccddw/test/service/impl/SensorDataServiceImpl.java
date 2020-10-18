package com.sccddw.test.service.impl;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.sccddw.test.config.mybatis.MybatisPlusConfig;
import com.sccddw.test.entity.db.SensorData;
import com.sccddw.test.mapper.SensorDataMapper;
import com.sccddw.test.service.ISensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author dell
 * date 2020/10/16 20:43
 * @version 1.0
 **/
@Service
public class SensorDataServiceImpl implements ISensorDataService {
    @Autowired
    SensorDataMapper sensorDataMapper;

    public void selectSensorData () {
        MybatisPlusConfig.myTableName.set("sensor_e_20201014");
        System.out.println( sensorDataMapper.selectById(1));
    }

    public void deleteAll () {
//        System.out.println( sensorDataMapper.deleteAll());

//        Wrapper<SensorData> wrapper = new DeWrapper();
//        sensorDataMapper.delete();
        Map<String, Object> map = new HashMap(); // 不加数据就是删除全部
        map.put("id", 3);
        System.out.println(sensorDataMapper.deleteByMap(map));

        SensorData sensorData = new SensorData();
        sensorData.setId(BigInteger.valueOf(1));
        sensorData.setDeviceCode("000000");
        sensorDataMapper.deleteByIdWithFill(sensorData);

        sensorData.insertOrUpdate();

        sensorDataMapper.deleteById(1);


    }
}
