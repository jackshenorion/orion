package com.shenpinyi.leecode.question396;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 29/03/2017.
 */
public class SolutionTest {

    @Test
    public void testMaxRotateFunction() throws Exception {
        System.out.println(new Solution().maxRotateFunction(new int[] {4, 3, 2, 6}));
        System.out.println(new Solution().maxRotateFunction(new int[] {4}));
        System.out.println(new Solution().maxRotateFunction(null));
    }
}