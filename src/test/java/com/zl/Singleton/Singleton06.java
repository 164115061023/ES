package com.zl.Singleton;

//完美的方法
//JVM保证单例
//加载外部类时不会加载内部类
public class Singleton06 {

    private Singleton06() {
    }

    private static class Singleton06Holder{
        private final static Singleton06 singleton = new Singleton06();
    }

    public static Singleton06 getInstance() {
        return Singleton06Holder.singleton;
    }

    //测试多线程下，单例模式成立（多线程安全）
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //jdk1.8之后的lambda表达式
            new Thread(() ->
                    System.out.println(Singleton06.getInstance().hashCode())
            ).start();
        }
    }

}
