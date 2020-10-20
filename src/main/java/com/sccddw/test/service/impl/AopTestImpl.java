package com.sccddw.test.service.impl;

import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author dell
 * date 2020/10/20 20:48
 * @version 1.0
 **/
@Service
public class AopTestImpl {
    public String test(String arg) {
        return arg;
    }
}
