package com.shenpinyi.algorithms.stack.sort_stack;

import java.util.Stack;

public class Solution {

    public void sort(Stack<Integer> stack, Stack<Integer> helper) {
        while (stack.size() > 0) {
            int number = stack.pop();
            insert(helper, stack, number);
        }
        while (helper.size() > 0) {
            stack.push(helper.pop());
        }
    }

    private void insert(Stack<Integer> target, Stack<Integer> source, int number) {
        while (target.size() > 0 && target.peek() > number) {
            source.push(target.pop());
        }
        target.push(number);
        while (source.size() > 0 && source.peek() > target.peek()) {
            target.push(source.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>();
        a.push(14);
        a.push(4);
        a.push(7);
        a.push(0);
        a.push(9);
        a.push(15);
        Stack<Integer> b = new Stack<>();

        new Solution().sort(a, b);
        System.out.println("a");
        while (a.size() > 0) {
            System.out.println(a.pop());
        }
        System.out.println("b");
        while (b.size() > 0) {
            System.out.println(b.pop());
        }
    }

}
