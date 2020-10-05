package com.zl.proxy;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/30 11:14
 * @Version 1.0
 */
public class LogProxy implements Movable{
    Movable m;

    public LogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("log start......");
        m.move();
        System.out.println("log end......");
    }
}
