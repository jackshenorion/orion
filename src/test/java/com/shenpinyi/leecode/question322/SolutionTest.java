package com.shenpinyi.leecode.question322;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 11/04/2017.
 */
public class SolutionTest {

    @Test
    public void testCoinChange() throws Exception {
        System.out.println(new Solution().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new Solution().coinChange(new int[]{1,5,98,99}, 103));
        System.out.println(new Solution().coinChange(new int[]{1,5,30,60,100}, 120));
        System.out.println(new Solution().coinChange(new int[]{1,5,6,40,100}, 991));
    }
}