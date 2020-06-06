package com.zl.controller;

import com.zl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/es")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/good/{keyword}")
    @ResponseBody
    public boolean setGoodsToES(@PathVariable String keyword){
        return goodsService.setGoodsToES(keyword);
    }

    @ResponseBody
    @RequestMapping("/search/{keyword}/{page}/{limit}")
    public List<Map<String,Object>> getAsMap(@PathVariable String keyword, @PathVariable Integer page,@PathVariable Integer limit){
        System.out.println(keyword);
        return goodsService.getAsMap(keyword,page,limit);
    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

}
