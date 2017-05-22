package com.shenpinyi.common.dp.superchoice;

/**
 * Created by jack on 18/05/2017.
 */
public class Solution {

    public static void superchoice() {
        int[] lens = new int[1000001];
        lens[1] = 1;
        lens[0] = 1;
        int maxLength = 1;
        int maxNumber = 2;
        for (int i = 2; i < lens.length; i ++) {
            int current = getLength(lens, i);
            if (current > maxLength) {
                maxLength = current;
                maxNumber = i;
            }
        }
        System.out.println("The Number:" + maxNumber + ", " + "The path length:" + maxLength);
        printPath(maxNumber);
    }

    public static void printPath(int n) {
        while (n != 1) {
            System.out.print(n + ",");
            if (isOdd(n)) {
                n = n * 3 + 1;
            } else {
                n = n >> 1;
            }
        }
    }

    public static int getLength(int[] lens, int n) {
        if (n > lens.length - 1) {
            return -1;
        } else if (lens[n] == -1) {
            return -1;
        } else if (lens[n] != 0) {
            return lens[n];
        }

        int nextLen = -1;
        if (isOdd(n)){
            nextLen = getLength(lens, n * 3 + 1);
        } else {
            nextLen = getLength(lens, n >> 1);
        }

        if (nextLen == -1) {
            lens[n] = -1;
        } else {
            lens[n] = nextLen + 1;
        }
        return lens[n];
    }

    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        superchoice();
        long end = System.currentTimeMillis();
        System.out.println("\nMilliseconds: " + (end - start));
    }

}
