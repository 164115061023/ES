package com.zl.Singleton;

import java.util.concurrent.TimeUnit;

//达到了想要的目的，看似完美，en... 确实也算不错
public class Singleton05 {

    private volatile static Singleton05 singleton;//思考为什么加volatile？

    private Singleton05() {
    }

    public static Singleton05 getInstance() {
        if (singleton == null) {
            synchronized (Singleton05.class) {
                if (singleton == null) {
                    //模拟业务场景，费点时间
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singleton = new Singleton05();
                }
            }
        }
        return singleton;
    }

    //测试多线程下，单例模式成立（多线程安全）
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //jdk1.8之后的lambda表达式
            new Thread(() ->
                    System.out.println(Singleton05.getInstance().hashCode())
            ).start();
        }
    }

}
