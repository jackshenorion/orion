package com.shenpinyi.lintcode.arraynumbers.question143;

public class Solution {

    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        partition(colors, 0, colors.length - 1, 1, k);
    }

    private void partition(int[] colors, int start, int end, int colorFrom, int colorTo) {
        if (start >= end) {
            return;
        }
        if (colorFrom == colorTo) {
            return;
        }
        int colorMid = (colorFrom + colorTo) / 2;
        int lower = start;
        int higher = end;
        while (lower <= higher) {
            while (lower <= higher && colors[lower] <= colorMid) {
                lower++;
            }
            while (lower <= higher && colors[higher] > colorMid) {
                higher--;
            }
            if (lower < higher) {
                int temp = colors[lower];
                colors[lower] = colors[higher];
                colors[higher] = temp;
                lower++;
                higher--;
            }
        }
        partition(colors, start, higher, colorFrom, colorMid);
        partition(colors, higher + 1, end, colorMid + 1, colorTo);
    }




    public void sortColors2B(int[] colors, int k) {
        int start = 0;
        for (int i = 1; i <= k; i++) {
            start = partition(colors, start, i);
        }
    }

    private int partition(int[] colors, int start, int num) {
        int lower = start;
        int higher = colors.length - 1;
        while (lower <= higher) {
            while (lower < higher && colors[lower] <= num) {
                lower++;
            }
            while (lower < higher && colors[higher] > num) {
                higher--;
            }
            int temp = colors[lower];
            colors[lower] = colors[higher];
            colors[higher] = temp;
            lower++;
            higher--;
        }
        return higher;
    }

}
