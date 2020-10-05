package com.zl.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/30 15:00
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "G:/project/XXX");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new MyCallback());
        Car car = (Car)enhancer.create();
        car.move();
    }

    static class MyCallback implements MethodInterceptor{

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("cglib前置操作");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("后置操作");
            return result;
        }
    }


}
