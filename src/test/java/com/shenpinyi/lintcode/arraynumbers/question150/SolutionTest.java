package com.shenpinyi.lintcode.arraynumbers.question150;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxProfit() {
        assertEquals(2, new Solution().maxProfit(new int[]{2,1,2,0,1}));
        assertEquals(0, new Solution().maxProfit(new int[]{2}));
        assertEquals(0, new Solution().maxProfit(new int[]{2,1}));
        assertEquals(2, new Solution().maxProfit(new int[]{2,1,2,3}));
        assertEquals(2, new Solution().maxProfit(new int[]{1,2,3}));
    }
}