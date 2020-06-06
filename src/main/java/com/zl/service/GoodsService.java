package com.zl.service;

import com.alibaba.fastjson.JSON;
import com.zl.pojo.Good;
import com.zl.util.HTMLJSoupUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public boolean setGoodsToES(String keyword){
        boolean set = false;
        List<Good> goodList = HTMLJSoupUtil.getGoods(keyword);
        BulkRequest request = new BulkRequest();
        request.timeout(TimeValue.MINUS_ONE);
        for (int i = 0; i < goodList.size(); i++) {

            request.add(
                    new IndexRequest("good").source(JSON.toJSONString(goodList.get(i)), XContentType.JSON)
            );
        }
        try {
            BulkResponse bulk = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
             set = !bulk.hasFailures();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }


    public List<Map<String,Object>> getAsMap(String keyword, Integer page, Integer limit){
        SearchRequest request = new SearchRequest("good");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name", keyword);
        searchSourceBuilder.query(queryBuilder);


        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder);

        request.source(searchSourceBuilder);

        List<Map<String ,Object>> list = new ArrayList<>();
        try {
            SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            for (SearchHit hit : search.getHits().getHits()) {

                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                HighlightField name = highlightFields.get("name");
                System.out.println(name);
                String title="";
                if(name!=null){

                    Text[] fragments = name.fragments();
                    for (Text fragment : fragments) {
                        title+=fragment;
                    }

                    sourceAsMap.put("name",title);
                }


                list.add( hit.getSourceAsMap());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }



}
