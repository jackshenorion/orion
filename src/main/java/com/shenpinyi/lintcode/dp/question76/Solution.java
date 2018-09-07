package com.shenpinyi.lintcode.dp.question76;

public class Solution {

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] seqs = new int[nums.length];
        for (int i = 0; i < seqs.length; i++) {
            seqs[i] = 1;
        }
        int result = 1;
        for(int i = 0; i < nums.length; i++) {
            int maxSeq = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxSeq = Math.max(maxSeq, seqs[j] + 1);
                }
            }
            seqs[i] = maxSeq;
            result = Math.max(maxSeq, result);
        }
        return result;
    }

    public int longestIncreasingSubsequenceB(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] seqs = new int[nums.length];
        for (int i = 0; i < seqs.length; i++) {
            seqs[i] = -1;
        }
        int maxSeq = 0;
        for(int i = 0; i < nums.length; i++) {
            maxSeq = Math.max(maxSeq, helper(nums, i, seqs));
        }
        return maxSeq;
    }

    private int helper(int[] nums, int start, int[] seqs) {
        if (start > nums.length - 1) {
            return 0;
        } else if (start == nums.length - 1) {
            seqs[nums.length - 1] = 1;
            return 1;
        }
        if (seqs[start] != -1) {
            return seqs[start];
        }
        int currentVal = nums[start];
        int nextNotLess = start + 1;
        int seqLenWithCurrent = 1;
        while (nextNotLess < nums.length) {
            if (nums[nextNotLess] > currentVal) {
                seqLenWithCurrent = Math.max(helper(nums, nextNotLess, seqs) + 1, seqLenWithCurrent);
            }
            nextNotLess++;
        }
        seqs[start] = seqLenWithCurrent;
        return seqLenWithCurrent;
    }


}
