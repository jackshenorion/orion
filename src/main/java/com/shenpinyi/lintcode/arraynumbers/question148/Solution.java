package com.shenpinyi.lintcode.arraynumbers.question148;

public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int lower = 0;
        int higher = nums.length - 1;
        int i = 0;
        while (i <= higher) {
            if(nums[i] == 0) {
                swap(nums, lower, i);
                lower++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else { // 2
                swap(nums, higher, i);
                higher--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColorsB(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int lower = 0;
        int middle_lower = nums.length - 1;
        int middle_higher = nums.length - 1;
        while (lower <= middle_lower) {
            while (lower <= middle_lower && nums[lower] == 0) {
                lower++;
            }
            while (lower <= middle_lower && nums[middle_lower] == 1) {
                middle_lower--;
            }
            if (lower > middle_lower) {
                break;
            }
            if (nums[middle_lower] == 2) {
                int temp = nums[middle_higher];
                nums[middle_higher] = nums[middle_lower];
                nums[middle_lower] = temp;
                middle_higher --;
                middle_lower --;
            } else { // 0
                int temp = nums[lower];
                nums[lower] = 0;
                nums[middle_lower] = temp;
                lower ++;
            }
        }
    }
}
