package com.shenpinyi.lintcode.arraynumbers.intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jack on 11/06/2017.
 */
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int i : nums1) {
            numSet1.add(i);
        }
        for (int i : nums2) {
            if (numSet1.contains(i)) {
                intersection.add(i);
            }
        }
        int[] output = new int[intersection.size()];
        int idx = 0;
        for (int i : intersection) {
            output[idx++] = i;
        }
        return output;
    }

    public static void main(String[] args) {
        printArray(new Solution().intersection(
            new int[]{1, 2, 2, 1},
            new int[]{2, 2}
        ));
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
