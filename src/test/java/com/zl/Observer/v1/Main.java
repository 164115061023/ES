package com.zl.Observer.v1;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        boolean flag = true;
        while (flag) {

            //每隔一秒去观察一下
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (child.getCry()) {
                // do something
                flag = false;
            }
        }
    }
}
