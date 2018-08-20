package com.shenpinyi.lintcode.arraynumbers.question151;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxProfit() {
        int[] prices = new int[]{4,4,6,1,1,4,2,5};
        assertEquals(6, new Solution().maxProfit(prices));
    }

    @Test
    public void getBeforeMaxProfits() {
        int[] prices = new int[]{4,4,6,1,1,4,2,5};
        assertArrayEquals(new int[]{0,0,2,2,2,3,3,4}, new Solution().getBeforeMaxProfits(prices));
    }

    @Test
    public void getAfterMaxProfits() {
        int[] prices = new int[]{4,4,6,1,1,4,2,5};
        assertArrayEquals(new int[]{4,4,4,4,4,3,3,0}, new Solution().getAfterMaxProfits(prices));
    }
}