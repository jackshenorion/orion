package com.shenpinyi.lintcode.binarysearch.question75;

public class Solution {

    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int[] nums = A;
        int lower = 0;
        int higher = nums.length - 1;
        while (lower + 1 < higher){
            int mid = lower + (higher - lower) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // peak
                return mid;
            } else if (nums[mid] > nums[mid - 1]) { //ascending
                lower = mid;
            } else { // descending
                higher = mid;
            }
        }
        return -1; // will not reach here
    }
}
