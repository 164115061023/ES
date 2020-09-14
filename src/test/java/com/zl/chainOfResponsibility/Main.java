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
        msg.setMsg("123456789<script>:)007");
        new CharFilter().doFilter(msg);
        new SensitiveWordFilter().doFilter(msg);
        new FaceFilter().doFilter(msg);
        System.out.println(msg);
    }
}
