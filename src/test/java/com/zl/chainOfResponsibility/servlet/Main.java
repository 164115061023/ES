package com.zl.chainOfResponsibility.servlet;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:38
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Request req = new Request();
        req.setMsg("<p>你好我是某某某</p>，我的个人网站是xxxxxx.com,草");
        Response resp = new Response();
        resp.setMsg("");
        FilterChain chain = new FilterChain();
        chain.doFilter(req, resp, chain);
        System.out.println(req);
        System.out.println(resp);
    }
}
