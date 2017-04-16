package com.shenpinyi.leecode.question77;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 15/04/2017.
 */
public class SolutionTest {

    @Test
    public void testCombine() throws Exception {
        System.out.println(new Solution().combine(4, 0));
        System.out.println(new Solution().combine(0, 0));
        System.out.println(new Solution().combine(4, 4));
        System.out.println(new Solution().combine(4, 5));
    }
}