package com.shenpinyi.leecode.question122;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 17/04/2017.
 */
public class SolutionTest {

    @Test
    public void testMaxProfit() throws Exception {
        System.out.println(new Solution().maxProfit(new int[]{0,0,0,0,0}));
        System.out.println(new Solution().maxProfit(new int[]{0,1,0,1,0}));
        System.out.println(new Solution().maxProfit(new int[]{0,1,2,1,2}));
        System.out.println(new Solution().maxProfit(new int[]{2,1,0,0,2}));
    }
}