package com.shenpinyi.lintcode.arraynumbers.question6;

public class SolutionB {

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }

        int pointA = 0;
        int pointB = 0;
        int[] result = new int[A.length + B.length];
        int pointResult = 0;

        while (pointA < A.length && pointB < B.length) {
            int valueA = A[pointA];
            int valueB = B[pointB];
            if (valueA <= valueB) {
                result[pointResult] = valueA;
                pointA++;
            } else {
                result[pointResult] = valueB;
                pointB++;
            }
            pointResult++;
        }

        int pointC;
        int[] C;
        if (pointA == A.length) {
            pointC = pointB;
            C = B;
        } else {
            pointC = pointA;
            C = A;
        }

        while (pointC < C.length) {
            result[pointResult] = C[pointC];
            pointResult++;
            pointC++;
        }
        return result;
    }
}
