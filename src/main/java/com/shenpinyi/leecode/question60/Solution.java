package com.shenpinyi.leecode.question60;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 27/03/2017.
 */
public class Solution {

    static int[] p = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation1(int n, int k) {
        if (k <= 0 || k > p[n]) {
            return "";
        }

        List<Integer> pItems = new ArrayList<>(10);
        List<Integer> rItems = new ArrayList<>(10);
        for (int i = 1; i <= n; i ++) {
            rItems.add(i);
        }

        for (int i = n; i > 0; i --) {
            if (k < p[i - 1]) {
                pItems.add(rItems.remove(0));
            }
        }

        getPermutation(pItems, rItems, k);

        StringBuilder builder = new StringBuilder();
        pItems.forEach(c -> builder.append(c));
        return builder.toString();
    }

    private void getPermutation(List<Integer> pItems, List<Integer> rItems, int k) {
        int n = rItems.size();
        if (n == 1) {
            pItems.add(rItems.remove(0));
            return;
        } else {
            int group = p[n - 1];
            int groupNumber = k / group;
            int subNumber = k % group;
            groupNumber = subNumber > 0 ? groupNumber + 1 : groupNumber;
            pItems.add(rItems.remove(groupNumber - 1));
            getPermutation(pItems, rItems, k - (groupNumber - 1) * group);
        }
    }

    public String getPermutation(int n, int k) {
        boolean[] output = new boolean[n];
        StringBuilder buf = new StringBuilder("");

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * i;

        for (int i = n - 1; i >= 0; i--) {
            int s = 1;

            while (k > res[i]) {
                s++;
                k = k - res[i];
            }

            for (int j = 0; j < n; j++) {
                if (j + 1 <= s && output[j]) {
                    s++;
                }
            }

            output[s - 1] = true;
            buf.append(Integer.toString(s));
        }

        return buf.toString();
    }
}
