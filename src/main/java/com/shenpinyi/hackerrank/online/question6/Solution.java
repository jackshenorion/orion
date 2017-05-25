package com.shenpinyi.hackerrank.online.question6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jack on 2/05/2017.
 */
public class Solution {
    static String number(int input) {
        List<Integer> primes = getPrimes(30);
        Set<Integer> cubes = getPrimeCubes(primes);
        return cubes.contains(input) ? "YES" : "NO";
    }

    public static Set<Integer> getPrimeCubes(List<Integer> primes) {
        Set<Integer> cubes = new HashSet<>();
        for (Integer i : primes) {
            cubes.add(i * i * i);
        }
        return cubes;
    }

    public static List<Integer> getPrimes(int max) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i ++) {
            if (isPrimeNumber(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrimeNumber(int n) {
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



    public static void main(String[] args) {

        System.out.print(number(512));
    }

}
