package com.zl;

import com.alibaba.fastjson.JSON;
import com.zl.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EsApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() {
    }

    /**
     * 创建索引 PUT index
     */
    @Test
    void createIndex(){
        //创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("good");
        try {
            //客户端执行请求
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            System.out.println(createIndexResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 判断索引是否存在
     */
    @Test
    void getIndex(){
        GetIndexRequest request = new GetIndexRequest("zhulei");
        try {
            boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
            System.out.println(exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除索引
     */
    @Test
    void deleteIndex(){
        DeleteIndexRequest request = new DeleteIndexRequest("test2");
        try {
            AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
            System.out.println(delete.isAcknowledged());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加文档PUT index/_doc/1{ }
     */
    @Test
    void addDocument(){
        User user = new User(1L,"zhulei",22);

        //创建请求
        IndexRequest request = new IndexRequest("zhulei");

        request.id("1");
        request.source(JSON.toJSONString(user), XContentType.JSON);
        try {
            //客户端发送请求
            IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            System.out.println(index.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断文档是否存在GET index/_doc/1
     * ，并获取文档信息
     */
    @Test
    void getDocument(){
        GetRequest request = new GetRequest("zhulei","1");
        try {
            boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
            System.out.println(exists);

            GetResponse documentFields = restHighLevelClient.get(request, RequestOptions.DEFAULT);
            System.out.println(documentFields.getSource());
            System.out.println(documentFields.getSourceAsString());
            System.out.println(documentFields);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新文档
     */
    @Test
    void updateDocument(){
        UpdateRequest request = new UpdateRequest("zhulei","1");
        User user = new User();
        user.setUsername("fz");
        user.setAge(2);
        request.doc(JSON.toJSONString(user),XContentType.JSON);
        try {
            UpdateResponse update = restHighLevelClient.update(request, RequestOptions.DEFAULT);
            System.out.println(update.status());
            System.out.println(update.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文档
     */
    @Test
    void deleteDocument(){
        DeleteRequest request = new DeleteRequest("zhulei","1");
        try {
            DeleteResponse delete = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
            System.out.println(delete.status());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量add/update/delete文档
     */
    @Test
    void addListDocument(){
        BulkRequest request = new BulkRequest("zhulei");

        List<User> userList = new ArrayList<>();
        userList.add(new User(1L,"zhulei1",22));
        userList.add(new User(2L,"zhulei2",22));
        userList.add(new User(3L,"zhulei3",22));
        userList.add(new User(4L,"zhulei4",22));
        userList.add(new User(5L,"zhulei5",22));

        for (int i = 0; i <userList.size() ; i++) {
            request.add(
                    //批处理add/update/delete
                    new IndexRequest().source(JSON.toJSONString(userList.get(i)),XContentType.JSON)
                    //new UpdateRequest().doc()
                    //new DeleteRequest("zhulei",""+(i+1))
            );
        }
        try {
            BulkResponse bulk = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
            System.out.println(bulk.status());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询（搜索）
     */
    @Test
    void searchDocument(){
        //1.创建查询请求
        SearchRequest request = new SearchRequest("zhulei");
        //2.构建搜索条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //builder.highlighter();
        //3.设置匹配条件
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "zhulei1");//精确匹配
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "zhulei1");
        builder.query(matchQueryBuilder);

        //4.搜索条件加入请求
        request.source(builder);
        try {
            //5.执行请求
            SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            for (SearchHit hit : search.getHits().getHits()) {
                System.out.println(hit.getSourceAsString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
