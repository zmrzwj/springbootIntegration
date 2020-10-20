package com.sccddw.test;

import com.sccddw.test.entity.db.MongoSensorData;
import com.sccddw.test.entity.db.SensorData;
import com.sccddw.test.service.impl.AopTestImpl;
import com.sccddw.test.service.impl.MongoSensorDataServiceImpl;
import com.sccddw.test.utils.EsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZwjSptingBootTestApplicationTests {
    @Autowired
    MongoSensorDataServiceImpl mongoSensorDataService;

    @Autowired
    AopTestImpl aopTest;

    @Test
    void contextLoads() {
        MongoSensorData sensorData = new MongoSensorData();
        sensorData.setDeviceCode("H01000001");
        sensorData.setAcquisitionTime("2020-10-11 12:11:11");
        mongoSensorDataService.save(sensorData);
    }

    @Test
    public void aspect(){
        aopTest.test("hello");
    }
}
