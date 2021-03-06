package com.zl.chainOfResponsibility;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 18:00
 * @Version 1.0
 */
public class FilterChain implements Filter{
    static List<Filter> filters = new LinkedList<>();
    static {
        filters.add(new SensitiveWordFilter());
        filters.add(new HTMLFilter());
        filters.add(new LinkFilter());
    }
    public void doFilter(Msg msg){
        for (int i = 0; i < filters.size(); i++) {
            filters.get(i).doFilter(msg);
        }
    }
    public void add(Filter filter){
        filters.add(filter);
    }
    public void remove(Filter filter){
        filters.remove(filter);
    }
}
