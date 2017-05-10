package com.shenpinyi.hackerrank.implementation.NonDivisibleSubset;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = in.nextInt();
        }
        System.out.println(getMaxSubsetLength(getMods(a, k)));
    }

    private static int[] getMods(int[] a, int k) {
        int[] mods = new int[k];
        for (int i = 0; i < a.length; i ++) {
            int mod = a[i] % k;
            mods[mod] ++;
        }
        return mods;
    }

    private static int getMaxSubsetLength(int[] mods) {
        int count = 0;
        for (int i = 1; i <= mods.length / 2; i ++) {
            if (i == mods.length - i && mods[i] > 0) {
                count ++;
            } else {
                count += Math.max(mods[i], mods[mods.length - i]);
            }
        }
        if (mods[0] > 0) {
            count ++;
        }
        return count;
    }

}