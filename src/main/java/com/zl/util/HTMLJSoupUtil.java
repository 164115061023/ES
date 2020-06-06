package com.zl.util;

import com.zl.pojo.Good;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class HTMLJSoupUtil {



    static List<Good> goodList = new ArrayList<>();

    public static void main(String[] args) {
        List<Good> goodList = HTMLJSoupUtil.getGoods("心理学");
        for (Good good : goodList) {
            System.out.println(good.toString());
        }
    }

    public static List<Good> getGoods(String keyword){
        String url = "https://search.jd.com/Search?keyword="+keyword;
        try {
            Document document = Jsoup.parse(new URL(url), 30000);
            Element element = document.getElementById("J_goodsList");
            System.out.println(element);
            Elements elements = element.getElementsByTag("li");
            for (Element el : elements) {
                String img = el.getElementsByTag("img").get(0).attr("src");
                String price = el.getElementsByClass("p-price").text();
                String name = el.getElementsByClass("p-name").text();
                Good good = new Good();
                good.setImg(img);
                good.setName(name);
                good.setPrice(price);
                goodList.add(good);
                /*System.out.println(img);
                System.out.println(price);
                System.out.println(name);*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodList;
    }


}
