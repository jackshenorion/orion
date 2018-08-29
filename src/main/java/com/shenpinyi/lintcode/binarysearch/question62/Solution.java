package com.shenpinyi.lintcode.binarysearch.question62;

public class Solution {

    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length < 1) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) { //left accenting
                if (A[mid] > target && A[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else // right accenting
                if (A[mid] < target && A[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
        }
        return A[start] == target ? start : A[end] == target ? end : -1;
    }


}
