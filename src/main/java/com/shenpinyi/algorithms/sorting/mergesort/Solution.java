package com.shenpinyi.algorithms.sorting.mergesort;

public class Solution {

    public void mergeSort(int[] a) {
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        mergeSort(b, 0, a.length - 1, a);
    }

    /**
     * @param b source array
     * @param l start of the index to sort, inclusive
     * @param r end of the index to sort, inclusive
     * @param a target array
     */
    private void mergeSort(int[] b, int l, int r, int[] a) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(a, l, m, b);
        mergeSort(a, m + 1, r, b);
        merge(b, l, m, r, a);
    }

    /**
     *
     * @param b source array, which contains 2 sorted sub-array
     * @param l start of left sub-array, inclusive
     * @param m end of left sub-array, inclusive
     * @param r end of right sub-array, inclusive
     * @param a target array
     */
    private void merge(int[] b, int l, int m, int r, int[] a) {
        int indexA = l;
        int indexB = m + 1;
        int target = l;
        while (indexA <= m && indexB <= r) {
            if (b[indexA] > b[indexB]) {
                a[target++] = b[indexB++];
            } else {
                a[target++] = b[indexA++];
            }
        }
        while (indexA <= m) {
            a[target++] = b[indexA++];
        }
        while (indexB <= r) {
            a[target++] = b[indexB++];
        }
    }

    private void mergeB(int[] b, int l, int m, int r, int[] a) {
        int indexA = l;
        int indexB = m + 1;
        int target = l;
        while (indexA <= m || indexB <= r) {
            if (indexA > m) {
                a[target] = b[indexB];
                indexB++;
            } else if (indexB > r) {
                a[target] = b[indexA];
                indexA++;
            } else if (b[indexA] > b[indexB]) {
                a[target] = b[indexB];
                indexB++;
            } else {
                a[target] = b[indexA];
                indexA++;
            }
            target++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{38, 27, 43, 3, 9, 82, 10};
        new Solution().mergeSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
