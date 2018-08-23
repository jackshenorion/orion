package com.shenpinyi.lintcode.arraynumbers.question56;

import java.util.*;

public class Solution {

    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            int check = target - current;
            if (numberToIndex.containsKey(check)) {
                return new int[]{numberToIndex.get(check), i};
            }
            numberToIndex.putIfAbsent(current, i);
        }
        return new int[]{-1, -1};
    }

}
