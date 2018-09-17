package com.shenpinyi.lintcode.arraynumbers.question943;

class NumArray {
    int[] sums = null;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sums == null) {
            return 0;
        }
        return sums[j + 1] - sums[i];
    }
}

