package com.shenpinyi.algorithms.sorting.linearsort;

public class CountingSort {


    /**
     * @param nums int arrays to be sorted
     * @param k    means all numbers in input are between [0..k]
     */
    public void sort(int[] nums, int k) {
        int[] c = new int[k + 1];
        for (int i = 0; i < nums.length; c[nums[i]]++, i++) ;
        for (int i = 1; i < c.length; c[i] += c[i - 1], i++) ;
        int[] work = new int[nums.length];
        System.arraycopy(nums, 0, work, 0, nums.length);
        for (int num : work) {
            nums[c[num] - 1] = num; // put num to position represented by counting c[num]
            c[num]--; // decrease count to represent the position of the next one
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};
        new CountingSort().sort(a, 6);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
