package com.shenpinyi.lintcode.dp.question514;

public class Solution {

    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }

        int[] sum = new int[2];
        sum[0] = k;
        sum[1] = k * k;
        for (int i = 2; i < n; i ++) {
            int currentIndex = i % 2;
            int lastIndex = (i - 1) % 2;
            sum[currentIndex] = sum[lastIndex] * (k - 1) + sum[currentIndex] * (k - 1);
        }
        return sum[(n - 1) % 2];
    }
}
