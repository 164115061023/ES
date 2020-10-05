package com.zl.proxy;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/30 11:07
 * @Version 1.0
 */
public class Car2 extends Car{
    public void move(){
        long startTime = System.currentTimeMillis();
        super.move();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
