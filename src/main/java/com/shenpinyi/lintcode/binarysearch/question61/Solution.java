package com.shenpinyi.lintcode.binarysearch.question61;

public class Solution {

    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length < 1) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) { // find first
            int mid = start + (end - start) / 2;
            int midValue = A[mid];
            if (midValue == target) {
                end = mid;
            } else if (midValue < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        int first = -1;
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first = end;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) { // find first
            int mid = start + (end - start) / 2;
            int midValue = A[mid];
            if (midValue == target) {
                start = mid;
            } else if (midValue < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        int last = -1;
        if (A[end] == target) {
            last = end;
        } else if (A[start] == target) {
            last = start;
        }
        return new int[]{first, last};
    }
}
