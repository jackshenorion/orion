package com.shenpinyi.hackerrank.sorting.BigSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by jack on 27/04/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() < o2.length()) {
                return -1;
            } else if (o1.length() > o2.length()) {
                return 1;
            } else {
                for (int i = 0; i < o1.length(); i ++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return 0;
            }
        });

        for (String s : unsorted) {
            System.out.println(s);
        }
    }
}
