package com.zl.Observer.v4;

import java.util.ArrayList;
import java.util.List;

public class Child {

    boolean cry = false;

    List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean getCry() {
        return cry;
    }

    public void wakeup() {
        cry = true;
        System.out.println("wakeup..wuwuwu....");
        for (Observer observer : observers) {
            observer.actionWakeup(new WakeUpEvent(System.currentTimeMillis(), "bed", this));
        }
    }

}
