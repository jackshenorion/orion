package com.shenpinyi.lintcode.datastructure.question40;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    Deque<Integer> stackPut = new ArrayDeque<>();
    Deque<Integer> stackGet = new ArrayDeque<>();
    public MyQueue() {
    }
    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stackPut.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (!stackGet.isEmpty()) {
            return stackGet.pop();
        } else {
            while(!stackPut.isEmpty()) {
                stackGet.push(stackPut.pop());
            }
            return stackGet.pop();
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (!stackGet.isEmpty()) {
            return stackGet.peek();
        } else {
            while(!stackPut.isEmpty()) {
                stackGet.push(stackPut.pop());
            }
            return stackGet.peek();
        }
    }
}

