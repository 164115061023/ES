package com.zl.proxy;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/30 11:16
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        new LogProxy(
                new TimeProxy(
                        new Car()
                )
        ).move();
    }
}
