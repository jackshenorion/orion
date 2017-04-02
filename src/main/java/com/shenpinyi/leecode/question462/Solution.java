package com.shenpinyi.leecode.question462;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jack on 2/04/2017.
 */
public class Solution {
    public int minMoves2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        int k = len >> 1;
        int i = 0;
        int j = len - 1;
        while (k-- > 0) {
            sum += nums[j--] - nums[i++];
        }
        return sum;
    }

    public int minMoves2b(int[] nums) {
        int len = nums.length;
        int k = len >> 1;
        List<Integer> list = new ArrayList<>(len);
        for (int i : nums) {
            list.add(i);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
        for (int i = 0; i < k; i ++) {
            queue.poll();
        }
        int mid = queue.peek();
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += Math.abs(nums[i] - mid);
        }
        return sum;
    }
}
