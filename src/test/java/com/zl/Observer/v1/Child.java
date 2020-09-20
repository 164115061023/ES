package com.zl.Observer.v1;

public class Child {

    boolean cry = false;

    public boolean getCry() {
        return cry;
    }

    public void wakeup() {
        cry = true;
        System.out.println("wakeup..wuwuwu....");
    }

}
