package com.shenpinyi.lintcode.arraynumbers.question31;

public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int lower = 0;
        int higher = nums.length - 1;
        while (lower < higher) {
            if (nums[lower] < k) {
                lower++;
                continue;
            }
            if (nums[higher] >=k) {
                higher--;
                continue;
            }
            int temp = nums[lower];
            nums[lower] = nums[higher];
            nums[higher] = temp;
        }
        return nums[lower] < k ? lower + 1 : lower;
    }
}
