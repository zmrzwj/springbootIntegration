package com.sccddw.test;

import com.sccddw.test.entity.bean.EsBean;
import com.sccddw.test.utils.EsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/5/12 16:30
 * @version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsUtilTests {
    @Autowired
    EsUtil esUtil;

    @Test
    public void Test() {
        boolean bool = esUtil.existsIndex("es_test");
        System.out.println("======");
        System.out.println(bool);
    }

    @Test
    public void TestInsertData() {
        List<EsBean> list = new ArrayList<>();

        for (int i =100; i < 2000; i++) {
            String iString = Integer.toString(i);
            Long price = new Long(1765);
            EsBean esBean = new EsBean();
            esBean.setId(iString);
            esBean.setName("hxf");
            esBean.setPrice(price);
            list.add(esBean);
        }


        boolean bool = esUtil.bulkData("es_test", list);
        System.out.println("======");
        System.out.println(bool);
    }

    @Test
    public void getApi() {
        boolean bool = esUtil.getSource("es_test");
        System.out.println("======");
        System.out.println(bool);
    }
}
