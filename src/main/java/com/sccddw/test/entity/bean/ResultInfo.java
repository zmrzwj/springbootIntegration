package com.sccddw.test.entity.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * description
 *
 * @author dell
 * date 2020/5/8 15:11
 * @version 1.0
 **/
public class ResultInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    @ApiModelProperty(value = "状态码")
    private Integer code;
    /** 消息 */
    @ApiModelProperty(value = "消息")
    private String msg;
    /** 数据对象 */
    @ApiModelProperty(value = "数据")
    private T data;


    public ResultInfo(){}

    public ResultInfo(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回无数据的成功结果封装对象
     * @return ResultInfo
     * @author xiaozhiwei
     * date: 2018/10/18 16:54
     */
    public static ResultInfo success() {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultCode(ResultCode.SUCCESS);
        return resultInfo;
    }

    /**
     * 返回带数据的成功结果封装对象
     * @param data 数据
     * @return ResultInfo
     * @author xiaozhiwei
     * date: 2018/10/18 16:55
     */
    public static ResultInfo success(Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultCode(ResultCode.SUCCESS);
        resultInfo.setData(data);
        return resultInfo;
    }

    /**
     * 返回无数据的失败结果封装对象
     * @param resultCode ResultCode
     * @return ResultInfo
     * @author xiaozhiwei
     * date: 2018/10/18 16:54
     */
    public static ResultInfo failure(ResultCode resultCode) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultCode(resultCode);
        return resultInfo;
    }

    /**
     * 返回带数据的失败结果封装对象
     * @param resultCode ResultCode
     * @param data 数据
     * @return ResultInfo
     * @author xiaozhiwei
     * date: 2018/10/18 16:54
     */
    public static ResultInfo failure(ResultCode resultCode, Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultCode(resultCode);
        resultInfo.setData(data);
        return resultInfo;
    }

    /**
     * 设置code和msg
     * @param code ResultCode
     * @author xiaozhiwei
     * date: 2018/10/18 17:05
     */
    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
