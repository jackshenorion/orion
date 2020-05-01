package com.shenpinyi.algorithms.sorting.mergesort;

public class SolutionBottomUp {

    public void mergeSort(int[] a) {
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        int[] source = b;
        int[] target = a;
        for (int width = 1; width < a.length; width *= 2) {
            for (int i = 0; i < a.length; i += 2 * width) {
                int left = i;
                int right = i + width;
                if (right < a.length) {
                    int end = Math.min(right + width - 1, a.length - 1);
                    merge(source, left, right, end, target);
                } else {
                    System.arraycopy(source, left, target, left, a.length - left);
                }
            }
            int[] temp = source;
            source = target;
            target = temp;
        }
        System.arraycopy(source, 0, a, 0, a.length);
    }

    private void merge(int[] b, int left, int right, int end, int[] a) {
        int indexA = left;
        int indexB = right;
        int target = left;
        while (indexA < right && indexB <= end) {
            if (b[indexA] > b[indexB]) {
                a[target++] = b[indexB++];
            } else {
                a[target++] = b[indexA++];
            }
        }
        while (indexA < right) {
            a[target++] = b[indexA++];
        }
        while (indexB <= end) {
            a[target++] = b[indexB++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{38, 27, 43, 3, 9, 82, 10};
        new SolutionBottomUp().mergeSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
