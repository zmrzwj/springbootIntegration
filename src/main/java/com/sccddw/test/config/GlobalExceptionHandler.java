package com.sccddw.test.config;


import com.sccddw.test.entity.bean.ResultCode;
import com.sccddw.test.entity.bean.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pkl
 * @version 1.0
 * @description  全局异常处理类，每一个自定义异常添加对应的一个方法即可
 * @Copyright (C), 成电大为科技有限公司
 * @date: 2019/6/17 10:03
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * @param request
     * @param exception
     * @description 一般异常，通过业务没有捕捉到的异常处理方法
     * @exception
     * @return com.sccddw.cpss.entity.bean.common.ResultInfo
     * @author pkl
     * date:   2019/6/17 20:13
     */
    @ExceptionHandler(value=Exception.class)
    public ResultInfo ExceptionHandle(HttpServletRequest request, Exception exception) {
        if(exception instanceof CommonException){
            CommonException ex = (CommonException) exception;
            return log(request,ex.getCode(),ex);
        }
        return log(request, ResultCode.INTERFACE_INNER_INVOKE_ERROR,exception);
    }

    /**
     * @param request
     * @param exception  异常
     * @description  错误日志集中打印及统一返回
     * @exception
     * @return void
     * @author pkl
     * date:   2019/6/17 20:08
     */
    public ResultInfo log(HttpServletRequest request, ResultCode resultCode, Exception exception){
        System.out.println("异常信息如下：" + exception.getMessage());
        StringBuilder exStr=new StringBuilder("");
        StackTraceElement[] trace=exception.getStackTrace();
//        获取堆栈信息并输出为打印的形式
        for(StackTraceElement s:trace){
            exStr.append("\tat " + s + "\r\n");
        }
        String lineSeparatorStr = System.getProperty("line.separator");
        //打印error级别的堆栈日志
        log.error("访问地址："+request.getRequestURL()+",请求方法："+request.getMethod()+",远程地址："+request.getRemoteAddr()+ lineSeparatorStr +"错误堆栈信息如下:"+ lineSeparatorStr +exStr);
        return new ResultInfo(resultCode.code(),resultCode.message()+exception.getMessage(),null);
    }
}
