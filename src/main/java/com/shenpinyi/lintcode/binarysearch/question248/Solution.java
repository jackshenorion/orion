package com.shenpinyi.lintcode.binarysearch.question248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        if (A == null || A.length == 0) {
            List<Integer> defResult = new ArrayList<>();
            for (int i = 0; i < queries.length; i ++) {
                defResult.add(0);
            }
            return defResult;
        }

        Arrays.sort(A);
        List<Integer> results = new ArrayList<>(queries.length);
        for (int query : queries) {
            results.add(countOfSmallerNumber(A, query));
        }
        return results;
    }

    private int countOfSmallerNumber(int[] a, int query) {
        int start = 0;
        int end = a.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == query) {
                end = mid;
            } else if (a[mid] < query) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (a[end] < query) {
            return end + 1;
        } else if (a[start] < query) {
            return start + 1;
        } else {
            return start;
        }
    }



}
