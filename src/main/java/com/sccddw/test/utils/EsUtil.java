package com.sccddw.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sccddw.test.entity.bean.EsBean;
import io.swagger.models.auth.In;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/5/12 11:35
 * @version 1.0
 **/
@Service
public class EsUtil {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    /**
     * 判断索引是否存在
     * @author zhangweijin
     * date 2020/5/12 16:28
     * @param indexName
     * return boolean
    **/
    public boolean existsIndex(String indexName) {
        try{
            GetIndexRequest request = new GetIndexRequest(indexName);
            boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
            return exists;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 插入单条数据
     * @author zhangweijin
     * date 2020/5/12 20:47
     * @param esBean
     * @param index
     * return
    **/
    public boolean insertData(EsBean esBean, String index) {
        IndexRequest indexRequest = new IndexRequest(index);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String source = mapper.writeValueAsString(esBean);
            indexRequest.source(source, XContentType.JSON);
            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /**
     * 批量插入
     * @author zhangweijin
     * date 2020/5/14 10:56
     * @param indexName
     * @param sources
     * return
    **/
    public boolean bulkData(String indexName,List<EsBean> sources) {
        BulkRequest bulkRequest = null;
        try {
            bulkRequest = new BulkRequest();
            ObjectMapper mapper = new ObjectMapper();
            for(EsBean esBean: sources) {
                IndexRequest indexRequest = new IndexRequest(indexName).id(esBean.getId()).source(mapper.writeValueAsString(esBean), XContentType.JSON);
                bulkRequest.add(indexRequest);
            }
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getSource(String indexName) {
        GetRequest getRequest = new GetRequest(indexName, "100");
        String[] includes = new String[]{};
        String[] excludes = Strings.EMPTY_ARRAY;
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
        getRequest.fetchSourceContext(fetchSourceContext);

        try {
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            String message = getResponse.getSourceAsString();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
