package com.shenpinyi.leecode.question334;

/**
 * Created by jack on 1/04/2017.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null) {
            return false;
        }
        int k = 0, a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        int len = nums.length;
        while (k < len) {
            int cur = nums[k];
            if (cur > b) {
                return true;
            }

            a = cur < a ? cur : a;
            b = cur > a ? cur : b;
            k++;
        }
        return false;
    }
}
