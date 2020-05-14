package com.sccddw.test.service.impl;

import com.sccddw.test.entity.testDO;
import com.sccddw.test.mapper.DrsrsAllocateDepotOrderDetailMapper;
import com.sccddw.test.service.DrsrsAllocateDepotOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author dell
 * date 2020/5/7 11:18
 * @version 1.0
 **/
@Service
public class DrsrsAllocateDepotOrderDetailImpl implements DrsrsAllocateDepotOrderDetailService {
    @Value("${zwj.name}")
    private String name;

    @Autowired
    DrsrsAllocateDepotOrderDetailMapper drsrsAllocateDepotOrderDetailMapper;


    @Override
    public testDO selectByPrimaryKey(Integer id) {
        System.out.println("selectByPrimaryKey");
        System.out.println(name);
        return drsrsAllocateDepotOrderDetailMapper.selectByPrimaryKey(id);
    }
}
