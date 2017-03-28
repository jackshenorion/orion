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

            // find min using binary search
            int temp = nums[k];
            int start = k + 1;
            int end = length - 1;

            while (end > start) {
                int midLower = (start + end) >> 1;
                int midHigher = midLower + 1;
                if (nums[midLower] > temp) {
                    end = midLower;
                } else {
                    start = midHigher;
                }
            }
            int ceiling = start;
            // swap k, min
            nums[k] = nums[ceiling];
            nums[ceiling] = temp;
        }
    }

    /**
     * find the first number from index i to index j that greater than x
     * @param a is ascend ordered
     * @param i
     * @param j
     * @param x
     * @return
     */
    private int binarySearch(int a[], int i, int j, int x) {
        int start = i;
        int end = j;

        while (end > start) {
            int midLower = (start + end) >> 1;
            int midHigher = midLower + 1;
            if (a[midLower] > x) {
                end = midLower;
            } else {
                start = midHigher;
            }
        }
        return start;
    }
}
