package com.shenpinyi.lintcode.arraynumbers.question547;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int idx = 0;
        for (Integer num : set1) {
            result[idx++] = num;
        }
        return result;
    }

    public int[] intersectionB(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        List<Integer> result = new ArrayList<>();
        while(p1 < nums1.length && p2 < nums2.length) {
            int value1 = nums1[p1];
            int value2 = nums2[p2];
            if (value1 < value2) {
                p1++;
            } else if (value2 < value1) {
                p2++;
            } else {
                p1++;
                p2++;
                if (result.size() == 0 || result.get(result.size() - 1) != value1) {
                    result.add(value1);
                }
            }
        }
        int[] resultInts = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultInts[i] = result.get(i);
        }
        return resultInts;
    }


}
