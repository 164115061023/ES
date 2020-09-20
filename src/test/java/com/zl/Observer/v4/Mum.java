package com.zl.Observer.v4;

public class Mum implements Observer {

    public void hug() {
        System.out.println("mum hug.....");
    }

    @Override
    public void actionWakeup(WakeUpEvent event) {
        hug();
    }
}
