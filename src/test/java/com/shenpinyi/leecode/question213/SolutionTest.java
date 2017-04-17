package com.shenpinyi.leecode.question213;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 17/04/2017.
 */
public class SolutionTest {

    @Test
    public void testRob() throws Exception {
        System.out.println(new Solution().rob(new int[]{}));
        System.out.println(new Solution().rob(new int[]{2}));
        System.out.println(new Solution().rob(new int[]{2, 4}));
        System.out.println(new Solution().rob(new int[]{2, 4, 1}));
        System.out.println(new Solution().rob(new int[]{2, 4, 3}));
        System.out.println(new Solution().rob(new int[]{2, 4, 3, 1, 2, 3}));
    }
}