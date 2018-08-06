package com.shenpinyi.concurrency.memoize;

public class PrimeChecker {

    public static boolean bruteForceChecker(long prime) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
