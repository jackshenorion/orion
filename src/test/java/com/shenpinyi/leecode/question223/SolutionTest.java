package com.shenpinyi.leecode.question223;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 30/03/2017.
 */
public class SolutionTest {

    @Test
    public void testComputeArea() throws Exception {
        int result = new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println(result);
    }
}