package com.shenpinyi.lintcode.datastructure.question12;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> valueStack = new Stack();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        valueStack.push(number);
        if (minStack.empty()) {
            minStack.push(number);
        } else {
            int lastMin = minStack.peek();
            minStack.push(number < lastMin ? number : lastMin);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        minStack.pop();
        return valueStack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}
