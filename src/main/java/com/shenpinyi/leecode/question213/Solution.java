package com.shenpinyi.leecode.question213;

/**
 * Created by jack on 17/04/2017.
 */
public class Solution {
    /**
     * based on question198, 这个题目非常的直接了。只要多考虑两个场景就可以了。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len== 1) {
            return nums[0];
        } else if (len== 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(
            nums[0] + rob(nums, 2, len - 2),
            rob(nums, 1, len - 1)
        );
    }

    private int rob(int[] nums, int from, int to) {
        int len = to - from;
        if (len < 0) {
            return 0;
        } else if (len == 0) {
            return nums[from];
        } else if (len == 1) {
            return Math.max(nums[from], nums[to]);
        }

        int pre = nums[from];
        int current = Math.max(nums[from], nums[from + 1]);
        for (int i = from + 2; i < from + len + 1; i++) {
            int temp = current;
            current = Math.max(current, nums[i] + pre);
            pre = temp;
        }
        return current;
    }

}
