package com.sccddw.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@MapperScan("com.sccddw.test.mapper")
public class ZwjSptingBootTestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ZwjSptingBootTestApplication.class, args);
    }

    /**
     * 将项目打成war包
     * 1:修改启动类，继承SpringBootServletInitializer，重写configure
     * 2:将packaging的值改为war
     * 2:在pom文件中去除tomcat的依赖
     * 改为打成jar包反过来操作即可
     * @param springApplicationBuilder build
     * @return SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(ZwjSptingBootTestApplication.class);
    }
}
