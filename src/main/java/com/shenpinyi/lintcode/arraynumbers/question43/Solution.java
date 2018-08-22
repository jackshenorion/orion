package com.shenpinyi.lintcode.arraynumbers.question43;

import java.util.List;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k:    An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int len = nums.length;
        int[][] results = new int[k + 1][len];
        int[][] g = getMaxSums(nums);
        // initialize the f(1, j) for k = 1
        for (int j = 0; j < len; j++) {
            results[1][j] = g[0][j];
        }
        for (int i = 2; i <= k; i++) {
            // for each i <= k, calculate f(i, j) = max(f(i-1, s) + g(s+1,j))
            // s means the end of the previous arrange
            // if level is i, then the end would be i - 1, which gives at least i numbers
            // i - 1 < j <= len - 1
            // i - 2 <= s <= j - 1
            for (int j = i - 1; j < len; j++) {
                int max = Integer.MIN_VALUE;
                for (int s = i - 2; s < j; s++) {
                    max = Math.max(max, results[i - 1][s] + g[s + 1][j]);
                }
                results[i][j] = max;
            }
        }
        return results[k][len - 1];
    }

    protected int[][] getMaxSums(int[] nums) {
        int length = nums.length;
        int[][] maxSums = new int[length][length];
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            int maxSum = sum;
            int minSum = Math.min(0, sum);
            maxSums[i][i] = maxSum;
            for (int j = i + 1; j < length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum - minSum);
                maxSums[i][j] = maxSum;
                minSum = Math.min(minSum, sum);
            }
        }
        return maxSums;
    }
}
