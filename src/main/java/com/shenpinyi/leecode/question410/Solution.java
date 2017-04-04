package com.shenpinyi.leecode.question410;

/**
 * Created by jack on 3/04/2017.
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] c = new int[n];
        int[] pre = new int[n];
        int[] temp;
        int sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += nums[i];
            c[i] = sum;
        }

        for (int j = 1; j < m; j ++) {
            temp = pre;
            pre = c;
            c = temp;
            c[j - 1] = pre[j - 1];
            for (int i = j; i < n; i ++) {
                if (nums[i] >= pre[i - 1]) {
                    c[i] = nums[i];
                } else {
                    int k = 0;
                    int a = 0;
                    while (k < i) {
                        a = a + nums[i - k];
                        if (a < pre[i - k - 1]) {
                            c[i] = pre[i - k - 1];
                            k ++;
                            continue;
                        } else {
                            c[i] = Math.min(a, pre[i - k]);
                            break;
                        }
                    }
                }
            }
        }
        return c[n - 1];

    }
}
