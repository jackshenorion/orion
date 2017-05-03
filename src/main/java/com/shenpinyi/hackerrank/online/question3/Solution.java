package com.shenpinyi.hackerrank.online.question3;

/**
 * Created by jack on 2/05/2017.
 */
public class Solution {
    static int summation(int[] numbers) {
        long sum = 0;
        for (int i = 0; i < numbers.length; i ++) {
            sum += numbers[i];
        }
        return (int) sum;
    }


    public static void main(String[] args) {

    }
}
