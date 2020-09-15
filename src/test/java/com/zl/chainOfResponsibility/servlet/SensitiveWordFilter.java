package com.zl.chainOfResponsibility.servlet;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:37
 * @Version 1.0
 */
public class SensitiveWordFilter implements Filter {
    @Override
    public void doFilter(Request req, Response resp, FilterChain chain) {
        String s = req.getMsg();
        s = s.replaceAll("草", "*");
        req.setMsg(s);
        chain.doFilter(req, resp, chain);
        String s2 = resp.getMsg();
        s2 = s2.concat("SensitiveWordFilter__");
        resp.setMsg(s2);
    }
}
