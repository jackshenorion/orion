package com.shenpinyi.lintcode.datastructure.question983;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * @param ops: the list of operations
     * @return:  the sum of the points you could get in all the rounds
     */
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("+")) {
                int last = stack.pop();
                int current = stack.peek() + last;
                stack.push(last);
                stack.push(current);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int result = 0;
        while (stack.size() > 0) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calPoints(new String[]{"5","2","C","D","+"}));
    }

}
