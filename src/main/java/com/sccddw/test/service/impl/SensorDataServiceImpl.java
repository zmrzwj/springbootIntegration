package com.sccddw.test.service.impl;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.sccddw.test.config.mybatis.MybatisPlusConfig;
import com.sccddw.test.mapper.SensorDataMapper;
import com.sccddw.test.service.ISensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
