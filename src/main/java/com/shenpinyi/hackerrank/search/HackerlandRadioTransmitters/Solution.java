package com.shenpinyi.hackerrank.search.HackerlandRadioTransmitters;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by jack on 27/04/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i ++) {
            set.add(x[i]);
        }

        Integer start = set.first();
        int count = 0;
        while (start != null) {
            count ++;
            start = getNextStart(start, set, k);
        }
        System.out.print(count);
    }

    private static Integer getNextStart(int start, TreeSet<Integer> set, int k) {
        int mid = set.floor(start + k);
        int end = set.floor((mid + k));
        return set.ceiling(end + 1);
    }

}
