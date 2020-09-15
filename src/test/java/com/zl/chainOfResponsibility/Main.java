package com.zl.chainOfResponsibility;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 17:38
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("<p>你好我是某某某</p>，我的个人网站是xxxxxx.com,草");
        FilterChain chain = new FilterChain();
        chain.doFilter(msg);
        System.out.println(msg);
    }
}
