package com.sccddw.test.service.impl;

import com.sccddw.test.dao.DeviceRepository;
import com.sccddw.test.dao.SensorDataRepository;
import com.sccddw.test.entity.db.MongoDevice;
import com.sccddw.test.entity.db.MongoSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/10/18 19:20
 * @version 1.0
 **/
@Service
public class MongoDeviceServiceImpl {
    @Autowired
    DeviceRepository deviceRepository;

    public void saveAll(List<MongoDevice> list) {
        deviceRepository.saveAll(list);
    }
}
