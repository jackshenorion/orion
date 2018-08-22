package com.shenpinyi.lintcode.arraynumbers.question45;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] lefMaxSums = createLeftMaxSums(nums);
        int[] rightMaxSums = createRightMaxSums(nums);
        int[] leftMinSums = createLeftMinSums(nums);
        int[] rightMinSums = createRightMinSums(nums);
        int maxDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDiff = Math.max(Math.abs(lefMaxSums[i] - rightMinSums[i + 1]), maxDiff);
            maxDiff = Math.max(Math.abs(leftMinSums[i] - rightMaxSums[i + 1]), maxDiff);
        }
        return maxDiff;
    }

    protected int[] createLeftMaxSums(int[] nums) {
        int minSum = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[] maxSums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            maxSums[i] = maxSum;
            minSum = Math.min(minSum, sum);
        }
        return maxSums;
    }

    protected int[] createRightMaxSums(int[] nums) {
        int minSum = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[] maxSums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            maxSums[i] = maxSum;
            minSum = Math.min(minSum, sum);
        }
        return maxSums;
    }

    protected int[] createLeftMinSums(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int[] minSums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, sum - maxSum);
            minSums[i] = minSum;
            maxSum = Math.max(maxSum, sum);
        }
        return minSums;
    }

    protected int[] createRightMinSums(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int[] minSums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            minSum = Math.min(minSum, sum - maxSum);
            minSums[i] = minSum;
            maxSum = Math.max(maxSum, sum);
        }
        return minSums;
    }

}
