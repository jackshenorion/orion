package com.shenpinyi.javaUtils.concurrency;

/**
 * Created by jack on 26/04/2017.
 */
public class Concurrency {

    public static void run1() {
        Thread t = new Thread();
        t.start(); // this thread run nothing, and no exception is thrown out
    }

    public static void run2() {
        Thread t = new Thread(() -> {
            System.out.println("Id: " + Thread.currentThread().getId() +
                ", Name:" + Thread.currentThread().getName() + ", Priority:" + Thread.currentThread().getPriority());
        }); // Id: 11, Name:Thread-1, Priority:5
        t.start();
    }

    public static void run3() {
        Thread myThread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("Id: " + Thread.currentThread().getId() +
                    ", Name:" + Thread.currentThread().getName() + ", Priority:" + Thread.currentThread().getPriority());
            }
        };
        myThread.start();
    }

    public static void run4() {
        new Thread();
    }



}
