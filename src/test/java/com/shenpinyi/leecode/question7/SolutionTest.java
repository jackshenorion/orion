package com.shenpinyi.leecode.question7;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 15/04/2017.
 */
public class SolutionTest {

    @Test
    public void testReverse() throws Exception {
        System.out.println(new Solution().reverse(-2147483412));
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE - 1);
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
    }
}