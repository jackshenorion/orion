package com.shenpinyi.leecode.question59;

/**
 * Created by jack on 1/04/2017.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int seq = 1;
        int a[][] = new int[n][n];
        int k = 0;
        int g = n >> 1;
        while (k < g) {
            int m = n - (k << 1) - 1;
            for (int i = k; i < n- k - 1; i ++) {
                a[k][i] = seq;
                a[i][n - k - 1] = seq + m;
                a[n - k - 1][n - i - 1] = seq + (m << 1);
                a[n - i - 1][k] = seq + (m << 1) + m;
                seq ++;
            }
            seq += m + m + m;
            k++;
        }

        if ((n & 1) == 1) {
            a[g][g] = seq;
        }
        return a;
    }
}
