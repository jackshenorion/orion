package com.shenpinyi.leecode.question462;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 2/04/2017.
 */
public class SolutionTest {

    @Test
    public void testMinMoves2() throws Exception {
        System.out.println(new Solution().minMoves2(new int[]{4,5,1,2}));
        System.out.println(new Solution().minMoves2(new int[]{4}));
        System.out.println(new Solution().minMoves2(new int[]{4, 1}));
    }
}