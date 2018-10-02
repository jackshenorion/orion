package com.shenpinyi.lintcode.binarysearch.question457;

public class Solution {

    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public int findPositionA(int[] nums, int target) {
        int start = -1;
        int end = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    public int findPositionB(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        return findPosition(nums, 0, nums.length - 1, target);
    }

    private int findPosition(int[] nums, int start, int end, int target) {
        if (start + 1 >= end ) {
            if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
        if (nums[start] > target || nums[end] < target) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        int newStart;
        int newEnd;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            newEnd = mid - 1;
            newStart = start + 1;
        } else {
            newStart = mid + 1;
            newEnd = end - 1;
        }
        return findPosition(nums, newStart, newEnd, target);
    }

}
