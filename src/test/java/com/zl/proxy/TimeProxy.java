package com.zl.proxy;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/30 11:13
 * @Version 1.0
 */
public class TimeProxy implements Movable{
    Movable m;

    public TimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
