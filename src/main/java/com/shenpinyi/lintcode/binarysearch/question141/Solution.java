package com.shenpinyi.lintcode.binarysearch.question141;

public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        int lower = 0;
        int higher = x;
        while (lower + 1 < higher) {
            int mid = lower + (higher - lower) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                lower = mid;
            } else {
                higher = mid;
            }
        }
        if (higher * higher <= x) {
            return higher;
        } else {
            return lower;
        }
    }
}
