package com.shenpinyi.leecode.question31;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 28/03/2017.
 */
public class SolutionTest {

    @Test
    public void testNextPermutation() throws Exception {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{3,2,1};
        int[] c = new int[]{1,1,5};
        int[] d = new int[]{3,6,2,5,4,1};
        int[] e = new int[]{2,3,1,3,3};
        new Solution().nextPermutation(a);
        new Solution().nextPermutation(b);
        new Solution().nextPermutation(c);
        new Solution().nextPermutation(d);
        new Solution().nextPermutation(e);
        printArray(a);
        printArray(b);
        printArray(c);
        printArray(d);
        printArray(e);
    }

    private void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println(" ");
    }
}