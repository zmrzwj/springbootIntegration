package com.sccddw.test.mapper;

import com.sccddw.test.entity.testDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DrsrsAllocateDepotOrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(testDO record);

    int insertSelective(testDO record);

    testDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(testDO record);

    int updateByPrimaryKey(testDO record);
}