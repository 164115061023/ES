package com.zl.Observer.v4;

public class WakeUpEvent {

    public long time;
    public String location;
    Child child;
    public WakeUpEvent(long time, String location, Child child) {
        this.time = time;
        this.location = location;
        this.child = child;
    }

    public Child getSource() {
        return child;
    }
}
