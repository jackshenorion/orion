package com.shenpinyi.lintcode.heap.question4;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return 1;
        }
        int factor2 = 0;
        int factor3 = 0;
        int factor5 = 0;
        int[] results = new int[n];
        results[0] = 1;
        int count = 1;
        while(count < n) {
            int val2 = results[factor2] * 2;
            int val3 = results[factor3] * 3;
            int val5 = results[factor5] * 5;
            int min = Math.min(val2, Math.min(val3, val5));
            if (min == val2) {
                factor2++;
            } else if (min == val3) {
                factor3++;
            } else {
                factor5++;
            }
            if (results[count - 1] != min) {
                results[count] = min;
                count++;
            }
        }
        return results[n - 1];
    }

    public int nthUglyNumberB(int n) {
        int count = 0;
        Queue<Integer> queue = new PriorityQueue();
        queue.offer(1);
        int result = 0;
        int a = Integer.MAX_VALUE / 2;
        int b = Integer.MAX_VALUE / 3;
        int c = Integer.MAX_VALUE / 5;
        while (count < n) {
            int next = queue.poll();
            if (next == result) {
                continue;
            }
            result = next;
            if (result < a) {
                queue.offer(result * 2);
            }
            if (result < b) {
                queue.offer(result * 3);
            }
            if (result < c) {
                queue.offer(result * 5);
            }
            count++;
        }
        return result;

    }

}
