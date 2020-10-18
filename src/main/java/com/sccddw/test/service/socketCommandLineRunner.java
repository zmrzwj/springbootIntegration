package com.sccddw.test.service;

import com.sccddw.test.service.impl.SocketIOServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author dell
 * date 2020/5/14 16:48
 * @version 1.0
 **/
@Component
@Slf4j
public class socketCommandLineRunner implements CommandLineRunner {
    @Autowired
    private SocketIOServiceImpl socketIOService;

    @Override
    public void run(String... args) throws Exception {
        /**
         * 当CommandLineRunner中出现不可预期的异常时，会影响主线程，所以这里单独启动一个线程执行
         */
        new Thread(){
            @Override
            public void run(){
                try {
                    log.info("开始启动");
//                    socketIOService.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
