package com.shenpinyi.common.heap;

/**
 * Created by jack on 7/05/2017.
 */
public class HeapSort {

    /**
     * HeapSort主要分两步完成:
     * 首先先heapify整个数组,构建一个最大堆,
     * 然后逐个将第一个元素(最小元素)放到已经排序的部分的开始,然后将替换到第一个元素siftDown
     *
     *
     */

    public void run(int[] a) {
        heapify(a);
        int lastSorted = a.length;
        for (int i = 0; i < a.length; i ++) {
            swap(a, 0, lastSorted - 1);
            lastSorted = lastSorted - 1;
            siftDown(a, 0, lastSorted - 1);
        }
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private void heapify(int[] a) {
        for (int i = a.length - 1; i > 0; i --) {
            siftUp(a, i);
        }
    }

    private void siftUp(int[] a, int idx) {
        if (idx <= 0) {
            return;
        }
        int parent = (idx - 1) / 2;
        if (a[parent] > a[idx]) {
            swap(a, parent, idx);
            siftUp(a, parent);
        }
    }

    private void siftDown(int[] a, int idx, int end) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        int min;
        if (left > end) {
            return;
        } else if (right > end) {
            min = left;
        } else {
            min = a[left] < a[right] ? left : right;
        }
        if (a[idx] > a[min]) {
            swap(a, idx, min);
            siftDown(a, min, end);
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{2,3,4,2,6,9,1,5,10,7};
        new HeapSort().run(a);
        for (int num : a) {
            System.out.print(" " + num);
        }

    }
}
