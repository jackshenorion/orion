package com.shenpinyi.lintcode.dp.question116;

public class Solution {

    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) { // top down + memorization
        if (A == null) {
            return false;
        } else if (A.length == 1) {
            return true;
        }
        int[] canJump = new int[A.length];
        for (int i = 0; i < A.length; i ++) {
            canJump[i] = -1;
        }
        return canJump(A, 0, canJump);
    }

    public boolean canJump(int[] A, int current, int[] canJump) {
        if (canJump[current] != -1) {
            return canJump[current] == 0 ? false : true;
        }
        if(current == A.length - 1) {
            canJump[current] = 1;
            return true;
        }
        int steps = A[current];
        canJump[current] = 0;
        for (int i = 1; i <= steps; i ++) {
            if (current + i > A.length - 1) {
                break;
            }
            if (canJump(A, current + i, canJump)) {
                canJump[current] = 1;
                break;
            }
        }
        return canJump[current] == 0 ? false : true;
    }


    public boolean canJumpBottomUp(int[] A) {
        if (A == null) {
            return false;
        } else if (A.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[A.length];
        canJump[A.length - 1] = true;
        for (int i = A.length - 2; i >= 0; i --) {
            int steps = A[i];
            for (int j = 1; j <= steps; j++) {
                if (i + j > A.length - 1) {
                    break;
                }
                if (canJump[i + j]) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[0];
    }


    public boolean canJumpGreedy(int[] A) {
        if (A == null) {
            return false;
        } else if (A.length == 1) {
            return true;
        }

        int maxSteps = 0;
        for(int i = 0; i < A.length; i++) {
            maxSteps--;
            maxSteps = Math.max(maxSteps, A[i]);
            if (maxSteps == 0 && i < A.length - 1) {
                return false;
            }
        }
        return true;
    }
}
