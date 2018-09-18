package com.shenpinyi.lintcode.heap.question81;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
// left: maxHeap
// right: minHeap
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 == o2 ? 0 : (o1 < o2 ?  1 : -1);
            }
        };
        Queue<Integer> leftHeap = new PriorityQueue<>(nums.length / 2 + 1, comparator);
        Queue<Integer> rightHeap = new PriorityQueue<>(nums.length / 2 + 1);
        int[] result = new int[nums.length];
        leftHeap.offer(Math.min(nums[0], nums[1]));
        rightHeap.offer(Math.max(nums[0], nums[1]));
        result[0] = nums[0];
        result[1] = leftHeap.peek();
        for (int i = 2; i < nums.length; i++) {
            int val = nums[i];
            int leftVal = leftHeap.peek();
            int rightVal = rightHeap.peek();
            if (val <= leftVal) {
                leftHeap.offer(val);
            } else if (val >= rightVal) {
                rightHeap.offer(val);
            } else {
                leftHeap.offer(val);
            }
            // numberLeft == numberRight or numberLeft == numberRight + 1
            if (leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.offer(leftHeap.poll());
            } else if (leftHeap.size() < rightHeap.size()) {
                leftHeap.offer(rightHeap.poll());
            }
            result[i] = leftHeap.peek();
        }
        return result;
    }
}
