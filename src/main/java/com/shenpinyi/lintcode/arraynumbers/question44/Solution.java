package com.shenpinyi.lintcode.arraynumbers.question44;

import java.util.List;

public class Solution {

    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        int maxsum = 0;
        int minsum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            minsum = Math.min(minsum, sum - maxsum);
            maxsum = Math.max(maxsum, sum);
        }
        return minsum;
    }
}
