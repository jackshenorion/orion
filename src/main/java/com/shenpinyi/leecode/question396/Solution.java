package com.shenpinyi.leecode.question396;

/**
 * Created by jack on 29/03/2017.
 */
public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 1) {
            return 0;
        }

        int len = A.length;
        int f0 = 0;
        int sum = 0;
        // calculate F0 and sum
        for (int i = 0; i < len; i ++) {
            f0 += i * A[i];
            sum += A[i];
        }

        // find maximum value
        int maxf = f0;
        int fk = f0;
        for (int i = 1; i <= len; i++) {
            fk = fk + sum - len * A[len - i];
            if (fk > maxf) {
                maxf = fk;
            }
        }
        return maxf;
    }
}
