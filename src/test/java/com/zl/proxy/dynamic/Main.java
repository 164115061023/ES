package com.zl.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/30 15:00
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Movable m = (Movable) Proxy.newProxyInstance(Car.class.getClassLoader(), new Class[]{Movable.class}, new MyInvocationHandler(car));
        m.move();
    }

    public static class MyInvocationHandler implements InvocationHandler{
        Car car;
        public MyInvocationHandler(Car car) {
            this.car = car;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("前置操作");
            Object o = method.invoke(car, args);
            System.out.println("后置操作");
            return o;
        }
    }
}
