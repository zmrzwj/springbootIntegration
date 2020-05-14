package com.sccddw.test.service;

import com.sccddw.test.entity.testDO;
import org.springframework.beans.factory.annotation.Value;

/**
 * description
 *
 * @author dell
 * date 2020/5/7 11:17
 * @version 1.0
 **/

public interface DrsrsAllocateDepotOrderDetailService {
    testDO selectByPrimaryKey(Integer id);
}
