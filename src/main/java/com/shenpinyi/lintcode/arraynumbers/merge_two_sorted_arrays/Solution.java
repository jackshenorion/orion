package com.shenpinyi.lintcode.arraynumbers.merge_two_sorted_arrays;

/**
 * Created by jack on 11/06/2017.
 */
public class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int[] ouput = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < lenA && j < lenB) {
            if (A[i] <= B[j]) {
                ouput[k] = A[i]; i ++;
            } else {
                ouput[k] = B[j]; j ++;
            }
            k ++;
        }

        int[] rest;
        int restIndex;
        if (i == lenA) {
            rest = B;
            restIndex = j;
        } else {
            rest = A;
            restIndex = i;
        }

        while (k < lenA + lenB) {
            ouput[k++] = rest[restIndex++];
        }
        return ouput;

    }


    public static void main(String[] args) {
        printArray(new Solution().mergeSortedArray(
            new int[]{1, 2, 3, 4},
            new int[]{2, 4, 5, 6}
        ));
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}