package com.sccddw.test.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * mybatis-plus自定义方法
 *
 * @author dell
 * date 2020/10/17 17:28
 * @version 1.0
 **/
public class DeleteAllMethod extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "delete from " + tableInfo.getTableName();
        String method = "deleteAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        return addDeleteMappedStatement(mapperClass,method, sqlSource);
    }
}
