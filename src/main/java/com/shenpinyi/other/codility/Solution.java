package com.shenpinyi.other.codility;

/**
 * Created by jack on 29/05/2017.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        long sum = sum(A);
        return findP(A, sum);
    }

    public long sum(int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length; i ++) {
            sum += A[i];
        }
        return sum;
    }

    public int findP(int[] A, long sum) {
        long half = 0;
        for (int i = 0; i < A.length; i ++) {
            if (half * 2 == (sum - A[i])) {
                return i;
            }
            half += A[i];
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1082132608, 0, 1082132608}));
    }
}
