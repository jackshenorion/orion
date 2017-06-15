package com.shenpinyi.lintcode.arraynumbers.merge_sorted_array;

class Solution {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;

        while (k != -1) {
            if (i != -1 && j != -1) {
                if (A[i] >= B[j]) {
                    A[k] = A[i];
                    i--;
                } else {
                    A[k] = B[j];
                    j--;
                }
            } else if (i == -1) {
                A[k] = B[j];
                j--;
            } else {
                A[k] = A[i];
                i--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{1, 4, 5, 0, 0};
        int B[] = new int[]{4, 5};
        new Solution().mergeSortedArray(
            A, 3,
            B, 2
        );

        printArray(A);
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}