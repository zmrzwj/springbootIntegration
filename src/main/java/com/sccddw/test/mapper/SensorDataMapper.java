package com.sccddw.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sccddw.test.entity.db.SensorData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * description
 *
 * @author dell
 * date 2020/10/16 20:42
 * @version 1.0
 **/
@Mapper
@Repository
public interface SensorDataMapper extends MyMapper<SensorData> {

}
