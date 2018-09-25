package com.shenpinyi.leecode.question16;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int current = nums[i];
            int newTarget = target - current;
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end];
                if (sum == newTarget) {
                    return target;
                } else if (sum > newTarget) {
                    end--;
                } else {
                    start++;
                }
                int diff = sum - newTarget;
                if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }
            }
        }
        return target + minDiff;
    }

}
