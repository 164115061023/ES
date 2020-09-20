package com.zl.Observer.v4;

public class Dog implements Observer {

    public void bark() {
        System.out.println("dog bark.....");
    }

    @Override
    public void actionWakeup(WakeUpEvent event) {
        bark();
    }
}
