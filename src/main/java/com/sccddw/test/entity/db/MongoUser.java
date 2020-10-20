package com.sccddw.test.entity.db;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * description
 *
 * @author dell
 * date 2020/10/20 10:52
 * @version 1.0
 **/
@Data
//@Document("user")
public class MongoUser {
    private BigInteger id;
    private String name;
    private String age;
}
