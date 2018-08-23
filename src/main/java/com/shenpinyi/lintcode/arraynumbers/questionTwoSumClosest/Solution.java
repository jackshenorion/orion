package com.shenpinyi.lintcode.arraynumbers.questionTwoSumClosest;

import java.util.Arrays;

public class Solution {

    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int diff = Math.abs(sum - target);
            minDiff = Math.min(minDiff, diff);
            if (minDiff == 0) {
                return 0;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return minDiff;
    }

}
