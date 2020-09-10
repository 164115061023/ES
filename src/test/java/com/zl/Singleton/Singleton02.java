package com.zl.Singleton;

import java.util.concurrent.TimeUnit;

//达到了按需初始化的目的，但是带来了更大的问题：线程不安全
public class Singleton02 {

    private static Singleton02 singleton;

    private Singleton02(){
    }

    public static Singleton02 getInstance(){
        if(singleton == null){

            //模拟业务场景，费点时间
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            singleton = new Singleton02();
        }
        return singleton;
    }

    //测试多线程下，单例模式不成立（多线程非安全）
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //jdk1.8之后的lambda表达式
            new Thread(()->
                    System.out.println(Singleton02.getInstance().hashCode())
            ).start();
        }
    }

}
