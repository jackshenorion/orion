package com.shenpinyi.leecode.question198;

/**
 * Created by jack on 17/04/2017.
 */
public class Solution {
    /**
     * 一个最简单的动态算法,使用线性时间解决
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int pre = nums[0];
        int current = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = current;
            current = Math.max(current, nums[i] + pre);
            pre = temp;
        }
        return current;
    }
}
