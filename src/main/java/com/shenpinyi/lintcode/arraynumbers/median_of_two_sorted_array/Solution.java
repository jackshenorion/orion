package com.shenpinyi.lintcode.arraynumbers.median_of_two_sorted_array;

/**
 * Created by jack on 11/06/2017.
 */
public class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int total = lenA + lenB;
        int mediemIndex = total / 2;
        double last = 0, current = 0;
        int i = 0, j = 0, k = 0;
        while(k <= mediemIndex) {
            last = current;
            if (i < lenA && j < lenB) {
                if (A[i] <= B[j]) {
                    current = A[i++];
                } else {
                    current = B[j++];
                }
            } else if (i == lenA) {
                current = B[j++];
            } else {
                current = A[i++];
            }
            k++;
        }
        return (total % 2 == 0) ? (last + current) / 2 : current;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(
            new int[]{5,6,7,10},
            new int[]{0,2,3,4}
        ));
    }
}
