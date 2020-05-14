package com.sccddw.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/test")
    @ApiOperation(value="我的测试")
    public String test(@RequestParam("id")String id) {
        return "hello test" + id;
    }
}
