package com.shenpinyi.leecode.question60;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 27/03/2017.
 */
public class Solution {

    static int[] p = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        if (k <= 0 || k > p[n]) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        List<Integer> rItems = new ArrayList<>(10); //numbers waiting to be added into permutation
        for (int i = 1; i <= n; i ++) {
            rItems.add(i);
        }

        int m = n;
        for (int i = n; i > 0; i --) {
            if (k < p[i - 1]) { // if k is within the p[i], then the upper numbers will be as they are
                builder.append(rItems.remove(0));
                m --;
            }
        }

        while (m > 0) {
            if (m == 1) {
                builder.append(rItems.remove(0));
            } else {
                int group = p[m - 1];
                int groupNumber = 1;
                while (k > group) {
                    k = k - group;
                    groupNumber ++;
                }
                builder.append(rItems.remove(groupNumber - 1));
            }
            m --;
        }

        return builder.toString();
    }
}

/**
 * From this task, we can find out:
 * 1. in order to improve performance, try to use while loop to replace recursive invoke
 * 2. some times, we can use loop deduction to get division and mod result if denominator is not too small
 */
