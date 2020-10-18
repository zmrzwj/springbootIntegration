package com.sccddw.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/10/17 17:49
 * @version 1.0
 **/
public interface MyMapper<T> extends BaseMapper<T> {
    int deleteAll();

    int insertBatchSomeColumn(List<T> list);

    int deleteByIdWithFill(T entity);

    int alwaysUpdateSomeColumnById(T entity);
}
