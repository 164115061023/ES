package com.zl.Observer.v2;

public class Child {

    boolean cry = false;

    Dad dad = new Dad();
    Mum mum = new Mum();
    Dog dog = new Dog();

    public boolean getCry() {
        return cry;
    }

    public void wakeup() {
        cry = true;
        System.out.println("wakeup..wuwuwu....");
        dad.feed();
        mum.hug();
        dog.bark();
    }

}
