package com.zl.proxy;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/30 10:13
 * @Version 1.0
 */
public class JD {

    AMD amd = new AMD();

    public void sellCPU(){
        System.out.println("前置操作，加价售卖");
        amd.sellCPU();
        System.out.println("后置操作，提供优质售后服务");
    }

}
