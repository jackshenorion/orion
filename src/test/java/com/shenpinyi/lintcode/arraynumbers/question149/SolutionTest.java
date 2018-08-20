package com.shenpinyi.lintcode.arraynumbers.question149;

import com.shenpinyi.lintcode.arraynumbers.question149.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxProfit() {
        assertEquals(1, new Solution().maxProfit(new int[]{3,2,3,1,2}));
    }

    @Test
    public void getMaxPrices() {
        int[] maxPrices = new Solution().getMaxPrices(new int[]{3, 2, 3, 1, 2});
        assertArrayEquals(new int[]{3,3,2,2,0}, maxPrices);
    }

    @Test
    public void maxProfitB() {
        assertEquals(1, new Solution().maxProfitB(new int[]{3,2,3,1,2}));
    }
}