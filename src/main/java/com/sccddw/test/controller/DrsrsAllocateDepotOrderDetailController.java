package com.sccddw.test.controller;

import com.sccddw.test.annotation.UserLoginToken;
import com.sccddw.test.entity.bean.MongoBean;
import com.sccddw.test.entity.bean.RedisBean;
import com.sccddw.test.entity.testDO;
import com.sccddw.test.mapper.DrsrsAllocateDepotOrderDetailMapper;
import com.sccddw.test.service.DrsrsAllocateDepotOrderDetailService;
import com.sccddw.test.utils.EsUtil;
import com.sccddw.test.utils.MongoUtil;
import com.sccddw.test.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/5/7 10:56
 * @version 1.0
 **/
@RestController
@Api(tags = {"DrsrsAllocateDepotOrderDetail"}, description = "DrsrsAllocateDepotOrderDetail查询")
public class DrsrsAllocateDepotOrderDetailController {

    @Autowired
    DrsrsAllocateDepotOrderDetailService drsrsAllocateDepotOrderDetailService;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    MongoUtil mongoUtil;

//    @Autowired
//    EsUtil esUtil;

    @GetMapping("/AllocateDepotOrderDetail")
    @ApiOperation(value="我的测试 AllocateDepotOrderDetail")
    public testDO test() {
        return drsrsAllocateDepotOrderDetailService.selectByPrimaryKey(17);
    }

    @GetMapping("/redisTest")
    @ApiOperation(value="我的测试 AllocateDepotOrderDetail")
    public Object redisTest(@RequestParam("value")String value) {
        RedisBean redisBean = new RedisBean("zwj", 28);
        String key = "20200511";
        redisUtil.add(key, value);
        String redisValue = redisUtil.get(key);

        redisUtil.addObj(key, redisBean);

        Object cacheRedisBean = redisUtil.getObj(key);
        System.out.println(cacheRedisBean);
        return cacheRedisBean;
    }

    @GetMapping("/mongoTest")
    @ApiOperation(value="我的测试 AllocateDepotOrderDetail")
    public List mongoTest(@RequestParam("value")String value) {
        MongoBean mongoBean = new MongoBean("567", "zwj", "你好呀", new Date());
        mongoUtil.saveObj(mongoBean);

        List list =  mongoUtil.findAll();

        System.out.println("===============================");

        Object mongoObj = mongoUtil.getObjById("123");
        System.out.println(mongoObj);
        return list;
    }

    @GetMapping("/esTest")
    @ApiOperation(value="我的测试 AllocateDepotOrderDetail")
    public String EsTest(@RequestParam("value")String value) {
//        boolean bool = esUtil.existsIndex("es_test");
//        System.out.println("======");
//        System.out.println(bool);
        return "es test";
    }
}
