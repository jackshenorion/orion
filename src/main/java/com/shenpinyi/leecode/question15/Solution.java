package com.shenpinyi.leecode.question15;

import java.util.*;

/**
 * Created by jack on 5/04/2017.
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || (nums[i - 1] != nums[i])) {
                int first = nums[i];
                int lower = i + 1, upper = nums.length - 1;
                while (lower < upper) {
                    if (nums[lower] + nums[upper] < (- first)) {
                        while (++lower < upper) {
                            if (nums[lower] == nums[lower - 1]) {
                                continue;
                            } else {
                                break;
                            }
                        }
                    } else {
                        if (nums[lower] + nums[upper] == (- first)) {
                            List<Integer> three = new ArrayList<>(3);
                            three.add(first);
                            three.add(nums[lower]);
                            three.add(nums[upper]);
                            output.add(three);
                        }

                        while (lower < --upper) {
                            if (nums[upper] == nums[upper + 1]) {
                                continue;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }


        return output;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums == null) {
            return output;
        }

        int len = nums.length;
        if (len < 3) {
            return output;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums[i];
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
        }

        int firstPre = nums[0] == Integer.MIN_VALUE ? 0 : Integer.MIN_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int first = nums[i];
            if (first > 0) {
                break;
            }

            if (first == firstPre) { // skip repeated value
                continue;
            } else {
                firstPre = first;
            }
            Integer value = map.get(first);
            if (value == null) {
                continue;
            } else if (value == 1) {
                map.remove(first);
            } else {
                map.put(first, value - 1);
            }

            int secondPre = nums[i + 1] == Integer.MIN_VALUE ? 0 : Integer.MIN_VALUE;
            for (int j = i + 1; j < len - 1; j ++) {
                int second = nums[j];
                if (second > (- first) >> 1) {
                    break;
                }

                if (second == secondPre) {
                    continue;
                } else {
                    secondPre = second;
                }

                int third = - first - second;
                Integer thirdValue = map.get(third);
                if (thirdValue == null) {
                    continue;
                } else if (second == third && thirdValue < 2) {
                    continue;
                } else {
                    output.add(new ArrayList<>(Arrays.asList(first, second, third)));
                }
            }

            map.remove(first);
        }

        return output;
    }
}
