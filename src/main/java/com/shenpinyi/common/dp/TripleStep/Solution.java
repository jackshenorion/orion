package com.shenpinyi.common.dp.TripleStep;

/**
 * Created by jack on 7/05/2017.
 */
public class Solution {

    public static int run(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        int[] previousCountOfPaths = new int[]{1, 2, 4};

        int step = 4;
        while (step <= n) {
            int count = previousCountOfPaths[0] + previousCountOfPaths[1] + previousCountOfPaths[2];
            step ++;
            previousCountOfPaths[0] = previousCountOfPaths[1];
            previousCountOfPaths[1] = previousCountOfPaths[2];
            previousCountOfPaths[2] = count;
        }
        return previousCountOfPaths[2];
    }

    public static void main(String args[]) {
        System.out.println(run(1));
        System.out.println(run(2));
        System.out.println(run(3));
        System.out.println(run(4));
        System.out.println(run(5));
    }

}
