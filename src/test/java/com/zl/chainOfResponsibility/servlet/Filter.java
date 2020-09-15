package com.zl.chainOfResponsibility.servlet;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:34
 * @Version 1.0
 */
public interface Filter {
    public void doFilter(Request req, Response resp, FilterChain chain);
}
