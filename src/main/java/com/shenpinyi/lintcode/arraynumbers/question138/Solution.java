package com.shenpinyi.lintcode.arraynumbers.question138;

import java.util.*;

public class Solution {

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> sums = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                return Arrays.asList(i, i);
            }
            sum += nums[i];
            if (sum == 0) {
                return Arrays.asList(0, i);
            }
            if (sums.containsKey(sum)) {
                return Arrays.asList(sums.get(sum) + 1, i);
            }
            sums.putIfAbsent(sum, i);
        }
        return Collections.EMPTY_LIST;
    }
}
