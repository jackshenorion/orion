package com.shenpinyi.lintcode.binarysearch.question183;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void woodCut() {

//        assertEquals(114, new Solution().woodCut(new int[]{232, 124, 456}, 7));
        assertEquals(2147483644, new Solution().woodCut(new int[]{2147483644,2147483645,2147483646,2147483647}, 4));

    }
}