package com.shenpinyi.leecode.question215;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by jack on 12/04/2017.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = nums[high];
        int mid = low;
        for (int i = low; i < high; i ++) {
            if (nums[i] < pivot) {
                swap(nums, mid, i);
                mid ++;
            }
        }
        swap(nums, mid, high);

        if (high - mid + 1 == k) {
            return nums[mid];
        } else if (high - mid + 1 > k) {
            return quickSelect(nums, mid + 1, high, k);
        } else {
            return quickSelect(nums, low, mid - 1, k - (high - mid + 1));
        }
    }

    private void shuffle(int[] nums) {

        final Random random = new Random();
        for(int ind = 1; ind < nums.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(nums, ind, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest_89(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest_65(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
