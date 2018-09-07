package com.shenpinyi.lintcode.dp.question117;

public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null) {
            return 0;
        } else if (A.length <= 1) {
            return 0;
        }
        int current = 0;
        int steps = 0;
        while (current < A.length - 1) {
            steps++;
            int canJump = A[current];
            if (canJump == 0) {
                return -1;
            }
            int toGo = current + 1;
            int nextFurthest = toGo;
            int next = current + 1;
            while (toGo <= current + canJump && toGo < A.length) {
                if (toGo == A.length - 1) {
                    return steps;
                }
                int thisFurthest = toGo + A[toGo];
                if (thisFurthest > nextFurthest) {
                    next = toGo;
                    nextFurthest = thisFurthest;
                }
                toGo++;
            }
            current = next;
        }
        return steps;
    }

    public int jumpDp(int[] A) {
        if (A == null) {
            return 0;
        }
        int[] steps = new int[A.length];
        for(int i = 0; i < steps.length; i ++) {
            steps[i] = -2;
        }
        steps[steps.length - 1] = 0;
        for (int i = steps.length - 2; i >= 0; i --) {
            int canGo = A[i];
            int minStep = Integer.MAX_VALUE;
            steps[i] = -1;
            for (int to = i + 1; to <= i + canGo; to ++) {
                if (to == steps.length - 1) {
                    minStep = 1;
                    break;
                } else if (steps[to] >= 0){
                    minStep = Math.min(minStep, steps[to] + 1);
                }
            }
            if (minStep != Integer.MAX_VALUE) {
                steps[i] = minStep;
            }
        }
        return steps[0];
    }
}
