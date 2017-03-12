package com.shenpinyi.microsoft.question012;

/**
 * Created by jack on 13/03/2017.
 */
public class SumCalculator {

    public static int sum(int n) {
        int[] sum = new int[]{0};
        add(sum, n);
        return sum[0];
    }

    private static boolean add(int[] sum, int j) {
        sum[0] += j;
        return j == 0 || add(sum, j - 1);
    }
}
