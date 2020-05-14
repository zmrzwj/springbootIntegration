package com.sccddw.test.config;

import com.sccddw.test.entity.bean.ResultCode;
import lombok.Data;

/**
 * description
 *
 * @author dell
 * date 2020/5/8 15:13
 * @version 1.0
 **/
@Data
public class CommonException extends RuntimeException{
    ResultCode code;

    public CommonException(String message) {
        super(message);
    }

    public CommonException(ResultCode code) {
        this.code = code;
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
}
