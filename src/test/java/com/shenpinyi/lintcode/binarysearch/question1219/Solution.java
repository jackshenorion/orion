package com.shenpinyi.lintcode.binarysearch.question1219;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Solution {

    /**
     * @param houses:  positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            while (j < heaters.length - 1
                    && Math.abs(heaters[j + 1] - house) < Math.abs(heaters[j] - house)) {
                j++;
            }
            radius = Math.max(radius, Math.abs(heaters[j] - house));
        }
        return radius;
    }

    public int findRadiusB(int[] houses, int[] heaters) {
        TreeSet<Integer> heaterSet = new TreeSet<>();
        for (int heater : heaters) {
            heaterSet.add(heater);
        }
        int radius = 0;
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            Integer left = heaterSet.floor(house);
            if (left == null) {
                left = Integer.MIN_VALUE;
            }
            Integer right = heaterSet.ceiling(house);
            if (right == null) {
                right = Integer.MAX_VALUE;
            }
            radius = Math.max(radius, Math.min(house - left, right - house));
        }
        return radius;
    }

}
