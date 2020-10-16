package com.sccddw.test.entity.db;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

//import java.sql.Date;

/**
 * description
 *
 * @author dell
 * date 2020/9/28 10:41
 * @version 1.0
 **/
@Data
public class SensorData implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private BigInteger id;
    private String deviceCode = null;
    private Double systemV = null;
    private Double batteryV = null;
    private Double sensorV = null;
    private Double lineV = null;
    private Integer signalStrength = null;
    private Integer transformerRatioN = null;
    private Integer transformerRatioM = null;
    private Double currentCoefficient = null;
    private Integer ch1Type = null;
    private Integer ch2Type = null;
    private Integer ch3Type = null;
    private Integer ch4Type = null;
    private Double ch1Value = null;
    private Double ch2Value = null;
    private Double ch3Value = null;
    private Double ch4Value = null;
    private String acquisitionTime;

    // insert时填充
//    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();

    // update时填充
//    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime = new Date();

    // 版本
//    @Version
//    private Integer version;

    // 标明逻辑删除字段
//    @TableLogic
//    @TableField(select = false)
//    private Integer deleted;
}
