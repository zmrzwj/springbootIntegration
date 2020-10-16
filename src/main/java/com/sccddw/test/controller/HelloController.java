package com.sccddw.test.controller;

import com.sccddw.test.annotation.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description zwj的测试
 * Copyright (C), 2019 by 四川成电大为科技有限公司
 *
 * @author zhangyiwei
 * @version 1.0
 * date：2019/7/2 16:25
 */
@RestController
@Api(tags = {"HelloController"}, description = "zwj的测试")
@RequestMapping("/hello")
public class HelloController {
//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    @ApiOperation(value="我的测试")
//    @UserLoginToken
    public String test() {
        for(int i = 0; i < 100;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    List rows = jdbcTemplate.queryForList("SELECT DISTINCT(CONS_NO) as C, DATA_DATA, SUM(R1) as s, RAND() * 1000 as r FROM mp_read_curve_jg_150 order by R3 DESC limit 100;");
//                    System.out.println(rows);
                }
            }).start();
        }

        return "hello test";
    }

    @GetMapping("/dm")
    @ApiOperation(value="达梦的测试")
    public String dm () {
        String sql = "select * from TABLE_zwj;";
//        List res = jdbcTemplate.queryForList(sql);
//        System.out.println(res);
        return  "dm";
    }
}
