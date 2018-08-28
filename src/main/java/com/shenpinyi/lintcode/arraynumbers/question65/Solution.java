package com.shenpinyi.lintcode.arraynumbers.question65;

import java.util.Arrays;
import java.util.List;

public class Solution {

    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int total = lenA + lenB;
        int k = (total + 1) / 2;
        if (total % 2 == 0) {
            Result kthValue = findKthValue(A, 0, B, 0, k);
            Result kPlusValue = findKthValue(A, kthValue.tillInA + 1, B, kthValue.tillInB + 1, 1);
            return (kthValue.value + kPlusValue.value) / 2.0;
        } else {
            return findKthValue(A, 0, B, 0, k).value;
        }
    }


    private Result findKthValue(int[] a, int startA, int[] b, int startB, int k) {
        if (startA >= a.length) {
            return new Result(false, startA - 1, startB + k - 1, b[startB + k - 1]);
        } else if (startB >= b.length) {
            return new Result(true, startA + k - 1, startB - 1, a[startA + k - 1]);
        }
        if (k == 1) {
             if (a[startA] <= b[startB]) {
                return new Result(true, startA, startB - 1, a[startA]);
            } else { // a[startA] > b[startB]
                return new Result(false, startA - 1, startB, b[startB]);
            }
        }
        int half = k / 2;
        int restA = a.length - startA;
        int restB = b.length - startB;
        int checkA = startA - 1 + Math.min(half, restA);
        int checkB = startB - 1 + Math.min(half, restB);
        if (a[checkA] == b[checkB]) {
            int tillA = checkA;
            int tillB = checkB;
            if (half * 2 == k) {
                return new Result(true, tillA, tillB, a[tillA]);
            } else {
                return findKthValue(a, tillA + 1, b, tillB + 1, 1);
            }
        } else if (a[checkA] > b[checkB]) {
            return findKthValue(a, startA, b, checkB + 1, k - half);
        } else { // a[checkA] < b[checkB]
            return findKthValue(a, checkA + 1, b, startB, k - half);
        }
    }

    static class Result {
        boolean inA;
        int tillInA;
        int tillInB;
        int value;

        public Result(boolean inA, int tillInA, int tillInB, int value) {
            this.inA = inA;
            this.tillInA = tillInA;
            this.tillInB = tillInB;
            this.value = value;
        }
    }


}
