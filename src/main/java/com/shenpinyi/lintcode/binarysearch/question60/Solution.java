package com.shenpinyi.lintcode.binarysearch.question60;

public class Solution {

    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            if (target < A[start]) {
                return start;
            } else if (target > A[end]) {
                return end + 1;
            } else {
                return start + 1;
            }
        }
    }

}
