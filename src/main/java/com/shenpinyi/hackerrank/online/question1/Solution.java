package com.shenpinyi.hackerrank.online.question1;

import java.util.*;

public class Solution {

    static int count = 0;
    public int combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        helper(a, target, 0);
        return count;
    }

    private void helper(int[] a, int target, int start) {
        for (int i = start; i < a.length; i++) {
            if(i > start && a[i] == a[i-1]) continue;
            if (a[i] >= target) {
                return;
            } else {

                int lower = start, upper = a.length - 1;
                while (lower < upper) {
                    if (a[lower] + a[upper] < target) {
                        return;
                    } else {
                        if (a[lower] + a[upper] == target) {
                            count++;
                            return;
                        }
                        while (lower < --upper) {
                            if (a[upper] == a[upper + 1]) {
                                continue;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
    }

}
