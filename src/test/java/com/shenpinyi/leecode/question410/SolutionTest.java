package com.shenpinyi.leecode.question410;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 3/04/2017.
 */
public class SolutionTest {

    @Test
    public void testSplitArray() throws Exception {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 3));
        System.out.println(new Solution().splitArray(new int[]{10, 2, 3}, 2));
        System.out.println(new Solution().splitArray(new int[]{2,3,1,1,1,1,1}, 5));
    }
}