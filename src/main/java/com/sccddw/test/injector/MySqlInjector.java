package com.sccddw.test.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.additional.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.additional.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/10/17 17:34
 * @version 1.0
 **/
@Component
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new DeleteAllMethod());

        methodList.add(new InsertBatchSomeColumn(t -> !t.isLogicDelete() && !t.getColumn().equals("age"))); // 把逻辑删除的字段和age字段都排除在数据里
        methodList.add(new LogicDeleteByIdWithFill()); //
        methodList.add(new AlwaysUpdateSomeColumnById(t -> !t.getColumn().equals("name"))); // name不进行更新

        return methodList;
    }
}
