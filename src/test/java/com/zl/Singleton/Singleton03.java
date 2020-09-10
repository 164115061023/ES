package com.zl.Singleton;

import java.util.concurrent.TimeUnit;

//达到了想要的目的，但效率底下
public class Singleton03 {

    private static Singleton03 singleton;

    private Singleton03(){
    }

    public static synchronized Singleton03 getInstance(){
        if(singleton == null){

            //模拟业务场景，费点时间
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            singleton = new Singleton03();
        }
        return singleton;
    }

    //测试多线程下，单例模式成立（多线程安全）
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //jdk1.8之后的lambda表达式
            new Thread(()->
                    System.out.println(Singleton03.getInstance().hashCode())
            ).start();
        }
    }

}
