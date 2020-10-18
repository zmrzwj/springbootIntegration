package com.sccddw.test;

import com.sccddw.test.entity.db.MongoDevice;
import com.sccddw.test.entity.db.MongoSensorData;
import com.sccddw.test.entity.db.SensorData;
import com.sccddw.test.service.impl.MongoDeviceServiceImpl;
import com.sccddw.test.service.impl.MongoSensorDataServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/10/18 15:29
 * @version 1.0
 **/
@SpringBootTest
public class MongoTests {
    @Autowired
    MongoSensorDataServiceImpl mongoSensorDataService;

    @Autowired
    MongoDeviceServiceImpl mongoDeviceService;

    @Test
    public void pageFindByAcquisitionTime() {
        Page<MongoSensorData> page =mongoSensorDataService.pageFindByAcquisitionTime("2020-10-11", 0, 10);
        System.out.println("page:");
        System.out.println(page.map(t -> {
            System.out.println(t);
            return t;
        }));
    }

    @Test
    public void save() {
//        List<MongoSensorData> list = new ArrayList<>();
//        for(int i = 10; i < 59; i++) {
//            MongoSensorData sensorData = new MongoSensorData();
//            sensorData.setDeviceCode("H01000003");
//            sensorData.setAcquisitionTime("2020-10-15 15:" + i + ":11");
//            list.add(sensorData);
//        }
//        mongoSensorDataService.saveAll(list);


        List<MongoDevice> list = new ArrayList<>();
        for(int i = 10; i < 59; i++) {
            MongoDevice sensorData = new MongoDevice();
            sensorData.setDeviceCode("H01000004");
            sensorData.setDeviceNumber(""+i);
            list.add(sensorData);
        }
        mongoDeviceService.saveAll(list);
    }

    @Test
    public void lookupOperationTest () {
        List list = mongoSensorDataService.lookupOperation("2020-10-15 15:16:11");
        list.forEach(System.out::println);
    }
}
