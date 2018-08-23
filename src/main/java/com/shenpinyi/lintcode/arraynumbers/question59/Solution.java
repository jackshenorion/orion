package com.shenpinyi.lintcode.arraynumbers.question59;

import java.util.Arrays;

public class Solution {

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return 0;
        } else if (numbers.length == 3) {
            return numbers[0] + numbers[1] + numbers[2];
        }
        Arrays.sort(numbers);
        int closest = numbers[0] + numbers[1] + numbers[2];
        int minDiff = Math.abs(closest - target);
        for (int i = 0; i < numbers.length - 2; i++) {
            int current = numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right] + current;
                if (Math.abs(sum - target) < minDiff) {
                    closest = sum;
                    minDiff = Math.abs(sum - target);
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closest;
    }
}
