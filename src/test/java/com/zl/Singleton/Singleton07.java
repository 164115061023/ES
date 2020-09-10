package com.zl.Singleton;

//不仅解决线程同步，而且可以防止方序列化
public enum  Singleton07 {

    singleton;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //jdk1.8之后的lambda表达式
            new Thread(() ->
                    System.out.println(singleton.hashCode())
            ).start();
        }
    }
}
