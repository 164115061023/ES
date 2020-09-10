package com.zl;

import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 {


    public static void main(String[] args) {

        System.out.println(3*0.1);

        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("t1interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            try {
                //lock.lock();
                System.out.println("t2 start1");
                lock.lockInterruptibly(); //可以对interrupt()方法做出相应
                System.out.println("t2 start2");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("t2interrupted!");
            } finally {
                //lock.unlock();
            }
        });
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//打断线程2的等待



    }




}
