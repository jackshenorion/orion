package com.shenpinyi.lintcode.binarysearch.question39;

import java.util.List;

public class Solution {

    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }
        int smallestIndex = getSmallestIndex(nums);
        if (smallestIndex == 0) {
            return;
        } else {
            rotate(nums, smallestIndex - 1);
        }

    }

    protected int getSmallestIndex(List<Integer> nums) {
        int minIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(minIndex)) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    protected void rotate(List<Integer> nums, int position) {
        if (position == nums.size() - 1) {
            return;
        }
        flip(nums, 0, position);
        flip(nums, position + 1, nums.size() - 1);
        flip(nums, 0, nums.size() - 1);
    }

    protected void flip(List<Integer> nums, int start, int end) {
        int lower = start;
        int higher = end;
        while (lower < higher) {
            int temp = nums.get(lower);
            nums.set(lower, nums.get(higher));
            nums.set(higher, temp);
            lower++;
            higher--;
        }
    }
}
