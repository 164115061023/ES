package com.zl.chainOfResponsibility.servlet;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:53
 * @Version 1.0
 */
public class LinkFilter implements Filter {
    @Override
    public void doFilter(Request req, Response resp, FilterChain chain) {
        String s = req.getMsg();
        s = s.replace("xxxxxx.com", "http://www.xxxxxx.com");
        req.setMsg(s);
        chain.doFilter(req, resp, chain);
        String s2 = resp.getMsg();
        s2 = s2.concat("LinkFilter__");
        resp.setMsg(s2);
    }
}
