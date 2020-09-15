package com.zl.chainOfResponsibility.servlet;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 18:00
 * @Version 1.0
 */
public class FilterChain implements Filter {
    int index = 0;
    static List<Filter> filters = new LinkedList<>();
    static {
        filters.add(new SensitiveWordFilter());
        filters.add(new HTMLFilter());
        filters.add(new LinkFilter());
    }
    public void doFilter(Request req, Response resp, FilterChain chain){
        if (filters.size() == index){
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(req, resp, chain);
    }
    public void add(Filter filter){
        filters.add(filter);
    }
    public void remove(Filter filter){
        filters.remove(filter);
    }
}
