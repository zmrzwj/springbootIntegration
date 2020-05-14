package com.sccddw.test.interceptor;

import com.sccddw.test.entity.bean.ResultCode;
import com.sccddw.test.entity.bean.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description 全局异常统一处理
 * Copyright (C), 2019 by 四川成电大为科技有限公司
 *
 * @author zhangyiwei
 * @version 1.0
 * date：2019/7/1 11:47
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultInfo handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || "".equals(msg)) {
            msg = "服务器出错";
        }
        ResultInfo resultInfo = new ResultInfo<>();
        resultInfo.setResultCode(ResultCode.PROGRAM_PROCESS_EXCEPTION);
        resultInfo.setMsg(msg);
        return resultInfo;
    }

}
