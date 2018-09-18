package com.shenpinyi.lintcode.heap.question130;

public class Solution {

    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
// root node starts from 0
// left = i * 2 + 1
// right = i * 2 + 2
// odd: left
// even: right
// parent: (i – 1) / 2
        if (A == null || A.length <= 1) {
            return;
        }
        int len = A.length;
        int lastParent = (len - 1 - 1) / 2;
        // from last parent to 0
        for(int i = lastParent; i >=0; i--) {
            heapify(A, i);
        }

    }
    private void heapify(int[] A, int current) {
        int len = A.length;
        int lastParent = (len - 1 - 1) / 2;
        if (current > lastParent) {
            return;
        }
        int left = current * 2 + 1;
        int right = current * 2 + 2;
        int leftValue = A[left];
        int rightValue = right >= len ? Integer.MAX_VALUE : A[right];
        int min = Math.min(leftValue, rightValue);
        if (A[current] <= min) {
            return;
        }
        int next = leftValue == min ? left : right;
        int temp = A[current];
        A[current] = A[next];
        A[next] = temp;
        heapify(A, next);
    }


}
