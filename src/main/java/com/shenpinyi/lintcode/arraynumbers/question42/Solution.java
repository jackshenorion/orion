package com.shenpinyi.lintcode.arraynumbers.question42;

import java.util.List;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        } else if (nums.size() == 1) {
            return nums.get(0);
        } else if (nums.size() == 2) {
            return nums.get(0) + nums.get(1);
        }
        int[] leftMaxSums = getLeftMaxSums(nums);
        int[] rightMaxSums = getRightMaxSums(nums);
        int maxSum = leftMaxSums[0] + rightMaxSums[1];
        for (int i = 1; i < nums.size() - 1; i ++) {
            maxSum = Math.max(maxSum, leftMaxSums[i] + rightMaxSums[i+1]);
        }
        return maxSum;
    }

    protected int[] getLeftMaxSums(List<Integer> nums) {
        int[] maxSums = new int[nums.size()];
        int maxSum = nums.get(0);
        maxSums[0] = maxSum;
        int sum = nums.get(0);
        int minSum = Math.min(0, sum);
        for (int i = 1; i < nums.size(); i++) {
            sum += nums.get(i);
            maxSum = Math.max(maxSum, sum - minSum);
            maxSums[i] = maxSum;
            minSum = Math.min(minSum, sum);
        }
        return maxSums;
    }

    protected int[] getRightMaxSums(List<Integer> nums) {
        int[] maxSums = new int[nums.size()];
        int maxSum = nums.get(nums.size() - 1);
        maxSums[nums.size() - 1] = maxSum;
        int sum = nums.get(nums.size() - 1);
        int minSum = Math.min(0, sum);
        for (int i = nums.size() - 2; i >= 0; i--) {
            sum += nums.get(i);
            maxSum = Math.max(maxSum, sum - minSum);
            maxSums[i] = maxSum;
            minSum = Math.min(minSum, sum);
        }
        return maxSums;
    }


}
