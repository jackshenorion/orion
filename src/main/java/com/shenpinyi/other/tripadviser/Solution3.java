package com.shenpinyi.other.tripadviser;


import java.util.Arrays;

public class Solution3 {

    static int numberOfPairs(int[] a, long k) {
        if (a == null || a.length <= 1) {
            return 0;
        }
        Arrays.sort(a);
        int start = 0;
        int end = a.length - 1;
        int result = 0;
        while (start < end) {
            if (start > 0 && a[start] == a[start - 1]) {
                start++;
                continue;
            }
            if (end < a.length - 1 && a[end] == a[end + 1]) {
                end--;
                continue;
            }
            int sum = a[start] + a[end];
            if (sum == k) {
                start++;
                result++;
            } else if (sum > k) {
                end --;
            } else {
                start++;
            }

        }
        return result;
    }
}
