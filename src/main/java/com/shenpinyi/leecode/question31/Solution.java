package com.shenpinyi.leecode.question31;

/**
 * Created by jack on 28/03/2017.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 1) {
            return;
        }

        // search for k
        int k = length - 2;
        while (k >= 0) {
            if (nums[k] < nums[k + 1]) {
                break;
            }
            k --;
        }

        if (k == length - 2) {
            // switch last 2
            int temp = nums[k];
            nums[k] = nums[k + 1];
            nums[k + 1] = temp;
        } else if (k < 0) {
            // reverse whole array
            for (int i = 0; i < length >> 1; i ++) {
                int temp = nums[i];
                nums[i] = nums[length - 1 - i];
                nums[length - 1 - i] = temp;
            }
        } else {
            // reverse sub array
            for (int i = 0; i < (length - k - 1) >> 1; i ++) {
                int temp = nums[i + k + 1];
                nums[i + k + 1] = nums[length - i - 1];
                nums[length - i - 1] = temp;
            }

            // find min
            int m = length - 1;
            int temp = nums[k];
            int min = -1;

            while (m > k) {
                if (min == -1 && nums[m] > temp) {
                    min = m;
                } else if (nums[m] > temp && nums[m] <= nums[min]) {
                    min = m;
                }
                m --;
            }

            // swap k, min
            nums[k] = nums[min];
            nums[min] = temp;
        }
    }
}
