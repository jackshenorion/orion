package com.shenpinyi.other.tripadviser;

public class Solution {

    static int calculateLargest(int max) {
        if (max <= 1) {
            return 0;
        }
        if (max == 2) {
            return 2;
        }
        int maxSum = 2;
        int result = 2;

        for (int i = 3; i <= max; i+=2) {
            if (isPrimeNumber(i)) {
                int sum = getAbsoluteSum(i);
                if (sum > maxSum) {
                    maxSum = sum;
                    result = i;
                }
            }
        }
        return result;
    }

    private static int getAbsoluteSum(int n) {
        int rest = n;
        int sum = 0;
        while (rest != 0) {
            sum += rest % 10;
            rest = rest / 10;
        }
        return sum;
    }

    private static boolean isPrimeNumber(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if ((n & 1) == 0) {
            return false;
        }

        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
