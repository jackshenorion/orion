package com.shenpinyi.concurrency.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {

    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 5;
                while (count > 0) {
                    try {
                        queue.put("This is the " + count + " message");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                }
                queue.add("EOF");
                queue.add("EOF");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    String msg = queue.take();
                    if (msg.equals("EOF")) {
                        return;
                    }
                    System.out.println(Thread.currentThread().getId() + " received " + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    String msg = queue.take();
                    if (msg.equals("EOF")) {
                        return;
                    }
                    System.out.println(Thread.currentThread().getId() + " received " + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



}
