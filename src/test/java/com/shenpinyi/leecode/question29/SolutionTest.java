package com.shenpinyi.leecode.question29;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 15/04/2017.
 */
public class SolutionTest {

    @Test
    public void testDivide() throws Exception {
        System.out.println(new Solution().divide(99, 5));
        System.out.println(new Solution().divide(-99, 5));
        System.out.println(new Solution().divide(99, -5));
        System.out.println(new Solution().divide(-99, -5));
        System.out.println(new Solution().divide(100, 5));
        System.out.println(new Solution().divide(-100, 5));
        System.out.println(new Solution().divide(100, -5));
        System.out.println(new Solution().divide(-100, -5));
        System.out.println(new Solution().divide(5, 100));
        System.out.println(new Solution().divide(-2147483648, -1));
        System.out.println(new Solution().divide(-2147483648, 1));
    }
}