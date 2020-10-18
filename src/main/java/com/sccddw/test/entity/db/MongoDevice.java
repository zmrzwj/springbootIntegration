package com.sccddw.test.entity.db;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

/**
 * description
 *
 * @author dell
 * date 2020/10/18 19:07
 * @version 1.0
 **/
@Data
@Document("mongoDevice")
public class MongoDevice {
    @Id
    private BigInteger id; // 主键
    private String deviceCode;
    private String deviceName;
    private String deviceNumber;
    private String installTime;
    private String remark;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime = new Date();
}
