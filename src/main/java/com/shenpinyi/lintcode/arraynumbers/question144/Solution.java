package com.shenpinyi.lintcode.arraynumbers.question144;

public class Solution {

    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        if (A == null || A.length <= 2) {
            return;
        }
        int lower = 0;
        int higher = A.length - 1;
        while (lower <= higher) {
            while (lower <= higher && A[lower] < 0) {
                lower++;
            }
            while (lower <= higher && A[higher] > 0) {
                higher--;
            }
            if (lower < higher) {
                int temp = A[lower];
                A[lower] = A[higher];
                A[higher] = temp;
                lower++;
                higher--;
            }
        }

        int neg = -1;
        int pos = -1;
        int numberOfNeg = higher + 1;
        int numberOfPos = A.length - numberOfNeg;
        if (numberOfNeg >= numberOfPos) {
            neg = 1;
            if (numberOfNeg % 2 == 0) {
                pos = higher + 1;
            } else {
                pos = higher + 2;
            }
        } else {
            neg = 0;
            if ((higher + 1) % 2 == 0) {
                pos = higher + 2;
            } else {
                pos = higher + 1;
            }
        }
        while (neg <= higher && pos < A.length) {
            int temp = A[neg];
            A[neg] = A[pos];
            A[pos] = temp;
            neg += 2;
            pos += 2;
        }
    }

}
