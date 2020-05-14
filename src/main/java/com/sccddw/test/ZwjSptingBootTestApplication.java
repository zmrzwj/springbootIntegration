package com.sccddw.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@MapperScan("com.sccddw.test.mapper")
public class ZwjSptingBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZwjSptingBootTestApplication.class, args);
    }

}
