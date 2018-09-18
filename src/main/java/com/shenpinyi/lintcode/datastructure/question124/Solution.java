package com.shenpinyi.lintcode.datastructure.question124;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        Set<Integer> numSet = new HashSet();
        for (int i = 0; i < num.length; i++) {
            numSet.add(num[i]);
        }
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int current= num[i];
            int count = 1;
            if (!numSet.contains(current)) {
                continue;
            }
            numSet.remove(current);
            int upper = current + 1;
            while(numSet.contains(upper)) {
                count++;
                numSet.remove(upper);
                upper++;
            }
            int down = current - 1;
            while(numSet.contains(down)) {
                count++;
                numSet.remove(down);
                down--;
            }
            max = Math.max(max, count);

        }
        return max;
    }
}
