package com.sccddw.test.dao;

import com.sccddw.test.entity.db.MongoDevice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * description
 *
 * @author dell
 * date 2020/10/18 19:17
 * @version 1.0
 **/
public interface DeviceRepository extends MongoRepository<MongoDevice, String> {
}
