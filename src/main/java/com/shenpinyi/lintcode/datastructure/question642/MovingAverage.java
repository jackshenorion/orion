package com.shenpinyi.lintcode.datastructure.question642;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {

    private Queue<Integer> queue;
    private int size;
    private long sum;

    /*
     * @param size: An integer
     */public MovingAverage(int size) {
         queue = new ArrayDeque<>();
         this.size = size;
         this.sum = 0;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return (double) sum / queue.size();
    }
}
