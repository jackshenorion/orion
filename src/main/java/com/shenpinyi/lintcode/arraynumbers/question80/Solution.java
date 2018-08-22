package com.shenpinyi.lintcode.arraynumbers.question80;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        int medianIndex = (nums.length - 1) / 2;
        return findKth(nums, 0, nums.length - 1, medianIndex);
    }

    protected int findKth(int[] nums, int start, int end, int k) {
        int pivotIndex = divide(nums, start, end);
        int pivotTh = pivotIndex - start;
        if (pivotTh == k) {
            return nums[pivotIndex];
        } else if (pivotTh < k) {
            int newK = k - pivotTh - 1;
            int newStart = pivotIndex + 1;
            int newEnd = end;
            return findKth(nums, newStart, newEnd, newK);
        } else {
            int newK = k;
            int newStart = start;
            int newEnd = pivotIndex - 1;
            return findKth(nums, newStart, newEnd, newK);
        }
    }

    protected int divide(int[] nums, int start, int end) {
        if (start == end) {
            return end;
        }
        int pivotIndex = end;
        int pivotValue = nums[end];
        int lower = start;
        int higher = end - 1;
        while (lower < higher) {
            if (nums[lower] <= pivotValue) {
                lower++;
            } else if (nums[higher] > pivotValue) {
                higher--;
            } else {
                swap(nums, lower, higher);
            }
        }
        if (nums[lower] <= pivotValue) {
            swap(nums, lower + 1, pivotIndex);
            return lower + 1;
        } else {
            swap(nums, lower, pivotIndex);
            return lower;
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
