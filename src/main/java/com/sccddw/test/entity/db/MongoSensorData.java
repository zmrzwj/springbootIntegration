package com.sccddw.test.entity.db;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * description
 *
 * @author dell
 * date 2020/10/18 14:52
 * @version 1.0
 **/
@Data
@Document("mongoSensorData")
// 复合索引,不过建议在命令行建
//@CompoundIndex(def = "{'userId': 1, 'nickname': -1}")
public class MongoSensorData implements Serializable {
    @Id
    private BigInteger id; // 主键

    @Indexed
    private String deviceCode = null;

    @Field("systemV") // 当属性与MongoDB字段的名字，不一致时可以使用Field做映射
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime = new Date();
}
