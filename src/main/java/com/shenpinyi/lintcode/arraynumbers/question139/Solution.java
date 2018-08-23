package com.shenpinyi.lintcode.arraynumbers.question139;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[0] = nums[0];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
            if (nums[i] == 0) {
                return new int[]{i, i};
            }
            if (sums[i] == 0) {
                return new int[]{0, i};
            }
        }
        int[] sortedSums = Arrays.copyOf(sums, sums.length);
        Arrays.sort(sortedSums);
        long minDiff = Math.abs(sortedSums[0]);
        int larger = 0;
        for (int i = 0; i < sortedSums.length - 1; i ++) {
            if (Math.abs(sortedSums[i + 1] - sortedSums[i]) < minDiff) {
                larger = i + 1;
                minDiff = Math.abs(sortedSums[i + 1] - sortedSums[i]);
            }
        }
        int indexA = -1;
        for (int i = 0; i < sums.length; i ++) {
            if (sums[i] == sortedSums[larger]) {
                indexA = i;
            }
        }
        if (larger > 0) {
            int indexB = -1;
            for (int i = 0; i < sums.length; i ++) {
                if (indexA == i) {
                    continue;
                }
                if (sums[i] == sortedSums[larger - 1]) {
                    indexB = i;
                }
            }
            return indexA > indexB ? new int[]{indexB + 1, indexA} : new int[]{indexA + 1, indexB};
        } else {
            return new int[]{0, indexA};
        }
    }

    public int[] subarraySumClosestB(int[] nums) {
        TreeMap<Integer, Integer> sumToIndex = new TreeMap<>();
        int sum = 0;
        long minDiff = Long.MAX_VALUE;
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                start = 0;
                end = 0;
                minDiff = Math.abs(nums[0]);
            }
            sum += nums[i];
            if (sum == 0) {
                return new int[]{0, i};
            }
            if (sumToIndex.containsKey(sum)) {
                return new int[]{sumToIndex.get(sum) + 1, i};
            }
            Integer smaller = sumToIndex.floorKey(sum);
            Integer larger = sumToIndex.ceilingKey(sum);
            if (smaller != null && Math.abs(sum - smaller) < minDiff) {
                minDiff = Math.abs(sum - smaller);
                start = sumToIndex.get(smaller) + 1;
                end = i;
            }
            if (larger != null && Math.abs(sum - larger) < minDiff) {
                minDiff = Math.abs(sum - larger);
                start = sumToIndex.get(larger) + 1;
                end = i;
            }
            sumToIndex.putIfAbsent(sum, i);
        }
        return new int[]{start, end};
    }

}
