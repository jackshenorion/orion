package com.shenpinyi.lintcode.arraynumbers.question43;

import java.util.List;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int len = nums.length;
        int[][] results = new int[k][len];
        int[] rightSums = getRightSums(nums);
        int[] leftSums = getLeftMaxSums(nums);
        for (int j = 0; j < len; j++) {
            results[0][j] = leftSums[j];
        }
        for (int i = 1; i <k; i++) {
            for (int till = i; till < len; till++) {
                int max = Integer.MIN_VALUE;
                for (int seg = i - 1; seg < len - 1; seg++) {
                    max = Math.max(max, results[i - 1][seg] + rightSums[seg + 1]);
                }
                results[i][till] = max;
            }
        }
        return results[k - 1][len - 1];
    }

    protected int[] getLeftMaxSums(int[] nums) {
        int[] maxSums = new int[nums.length];
        int maxSum = nums[0];
        maxSums[0] = maxSum;
        int sum = nums[0];
        int minSum = Math.min(0, sum);
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            maxSums[i] = maxSum;
            minSum = Math.min(minSum, sum);
        }
        return maxSums;
    }
    protected int[] getRightSums(int[] nums) {
        int[] maxSums = new int[nums.length];
        int maxSum = nums[nums.length - 1];
        maxSums[nums.length - 1] = maxSum;
        int sum = nums[nums.length - 1];
        int minSum = Math.min(0, sum);
        for (int i = nums.length - 2; i >= 0; i--) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            maxSums[i] = maxSum;
            minSum = Math.min(minSum, sum);
        }
        return maxSums;
    }


}
