package com.sccddw.test;

import com.sccddw.test.entity.bean.EsBean;
import com.sccddw.test.mapper.SensorDataMapper;
import com.sccddw.test.service.impl.SensorDataServiceImpl;
import com.sccddw.test.utils.EsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
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
@SpringBootTest
public class EsUtilTests {
    @Autowired
    EsUtil esUtil;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SensorDataServiceImpl sensorDataService;

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


    @Test
    public void testMysql() {
//        System.out.println("------------------");
//        for(int i = 0; i < 30;i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    List rows = jdbcTemplate.queryForList("SELECT DISTINCT(CONS_NO) as C, DATA_DATA, SUM(R1) as s FROM mp_read_curve_jg_150 where (DATE_FORMAT(DATA_DATA,'%Y-%m-%d') BETWEEN '2019-11-25' and '2019-12-31')  limit 10;");
//                    System.out.println(rows);
//                }
//            }).start();
//        }

//        sensorDataService.selectSensorData();

        sensorDataService.deleteAll();
    }
}
