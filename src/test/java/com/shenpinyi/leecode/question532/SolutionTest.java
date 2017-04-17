package com.shenpinyi.leecode.question532;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 17/04/2017.
 */
public class SolutionTest {

    @Test
    public void testFindPairs() throws Exception {
        System.out.println(new Solution().findPairs(new int[]{1,1,1,5,5}, 0));
        System.out.println(new Solution().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(new Solution().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new Solution().findPairs(new int[]{1, 2, 3, 4, 5}, -1));
    }
}