package com.sccddw.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author dell
 * date 2020/10/20 19:44
 * @version 1.0
 **/
@Aspect // 表明是一个切面类
@Component // 将当前类注入到Spring容器内
public class LogAspect {

    @Before("execution(public * com.sccddw.test.controller.HelloController.test(..))")
    public void before() {
        System.out.println("------------------hello 方法执行前-------------------");
    }

    @After("execution(public * com.sccddw.test.controller.HelloController.test(..))")
    public void after() {
        System.out.println("------------------hello 方法执行后-------------------");
    }

    @Pointcut("execution(public String test())")
    public void shareCut() {}

    @AfterReturning("shareCut()")
    public void log(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " executed");
    }

}
