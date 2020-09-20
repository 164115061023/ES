package com.zl.Observer.v4;

public class Dad implements Observer {

    public void feed(){
        System.out.println("dad feed......");
    }

    @Override
    public void actionWakeup(WakeUpEvent event) {
        feed();
    }
}
