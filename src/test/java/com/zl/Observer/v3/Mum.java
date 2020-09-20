package com.zl.Observer.v3;

public class Mum implements Observer{

    public void hug() {
        System.out.println("mum hug.....");
    }

    @Override
    public void actionWakeup() {
        hug();
    }
}
