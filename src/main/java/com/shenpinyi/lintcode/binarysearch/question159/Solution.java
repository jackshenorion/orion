package com.shenpinyi.lintcode.binarysearch.question159;

public class Solution {

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Integer.MIN_VALUE;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
