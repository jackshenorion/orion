package com.shenpinyi.leecode.question495;

/**
 * Created by jack on 28/03/2017.
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int preEnd = 0;
        int sum = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            int currentStart = timeSeries[i];
            int currentEnd = currentStart + duration;
            sum += timeSeries[i] < preEnd ? currentEnd - preEnd : duration;
            preEnd = currentEnd;
        }
        return sum;
    }
}
