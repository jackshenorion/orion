package com.shenpinyi.leecode.question309;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 2/04/2017.
 */
public class SolutionTest {

    @Test
    public void testMaxProfit() throws Exception {
        System.out.println(new Solution().maxProfit(new int[]{1, 4, 7, 1,4,7,1,4,7,1,4}));
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new Solution().maxProfit(new int[]{}));
    }
}