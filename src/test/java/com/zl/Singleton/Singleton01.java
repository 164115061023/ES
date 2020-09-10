package com.zl.Singleton;

//类加载到内存后就实例化一个对象，JVM保证线程安全
public class Singleton01 {

    private static final Singleton01 singleton = new Singleton01();

    private Singleton01(){
    }

    public static Singleton01 getInstance(){
        return singleton;
    }


    public static void main(String[] args) {
        Singleton01 singleton01 = Singleton01.getInstance();
        Singleton01 singleton02 = Singleton01.getInstance();
        System.out.println(singleton01==singleton02);
    }

}
