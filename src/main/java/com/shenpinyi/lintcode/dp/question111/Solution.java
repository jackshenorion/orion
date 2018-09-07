package com.shenpinyi.lintcode.dp.question111;

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int result = 1;
        int current = 2;
        while (current <= n) {
            result = first + second;
            first = second;
            second = result;
            current++;
        }
        return result;
    }
}
