package com.shenpinyi.other.nasdaq;

import java.math.BigInteger;

/**
 * Created by jack on 29/05/2017.
 */
public class Solution {

    public static BigInteger sumProducts(int n, int c) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger subSum = BigInteger.ONE;
        for (int i = 1; i < n; i ++) {
            sum = sum.add(subSum = product(subSum, c, i));
        }
        return sum;
    }

    public static BigInteger product(BigInteger previousSum, int maxCount, int nextNumber) {
        if (nextNumber <= maxCount) {
            return previousSum.multiply(BigInteger.valueOf(nextNumber));
        } else {
            return previousSum.multiply(BigInteger.valueOf(nextNumber)).divide(BigInteger.valueOf(nextNumber - maxCount));
        }
    }

    public static void main(String[] args) {
        System.out.println(sumProducts(5, 2));
        System.out.println(sumProducts(100, 10));
        System.out.println(sumProducts(1_000_000, 200));
        System.out.println(sumProducts(10_000_000, 200));
    }
}
