package com.shenpinyi.microsoft.questionFour;

public class MaxSubArray {
    private int[] items;

    public MaxSubArray(int[] input) {
        this.items = input;
    }

    public int[] getMaxSubArray() {
        int[] sums = new int[items.length];

        for (int i = 0; i < this.items.length; i++) {
            if (i == 0) {
                sums[0] = items[0];
            } else {
                if (sums[i - 1] < 0) {
                    sums[i] = items[i];
                } else {
                    sums[i] = sums[i - 1] + items[i];
                }
            }
        }

        int maxIdx = -1;
        int lowerIdx = -1;
        boolean inMaxRange = false;
        for (int i = this.items.length - 1; i >= 0; i--) {
            if (maxIdx == -1) {
                if (sums[i] > 0) {
                    inMaxRange = true;
                    maxIdx = i;
                    lowerIdx = i;
                }
            } else {
                if (sums[i] <= 0) {
                    inMaxRange = false;
                    continue;
                } else {
                    if (sums[i] > sums[maxIdx]) {
                        inMaxRange = true;
                        maxIdx = i;
                        lowerIdx = i;
                    } else {
                        if (inMaxRange) {
                            lowerIdx = i;
                        }
                    }
                }
            }
        }

        if (maxIdx < 0) {
            return null;
        }
        int[] result = new int[maxIdx - lowerIdx + 1];
        for (int i = lowerIdx; i <= maxIdx; i++) {
            result[i - lowerIdx] = items[i];
        }
        return result;
    }

}
