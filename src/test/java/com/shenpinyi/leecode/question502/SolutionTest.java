package com.shenpinyi.leecode.question502;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 13/04/2017.
 */
public class SolutionTest {

    @Test
    public void testFindMaximizedCapital() throws Exception {
        System.out.println(new Solution().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(new Solution().findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
        System.out.println(new Solution().findMaximizedCapital(5, 5, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }
}