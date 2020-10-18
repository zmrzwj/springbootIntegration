package com.sccddw.test.dao;

import com.sccddw.test.entity.db.MongoSensorData;
import com.sccddw.test.entity.db.SensorData;
import org.mapstruct.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/10/18 15:08
 * @version 1.0
 **/
//@Component
public interface SensorDataRepository extends MongoRepository<MongoSensorData, String> {

    Page<MongoSensorData> findByAcquisitionTimeContains(String acquisitionTime, Pageable pageable);


//    @Query("{'acquisitionTime': { $regex: '^?0'} }")
//    List<MongoSensorData> findSensorDataQuery(String acquisitionTime);
}
