package com.shenpinyi.leecode.question495;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 28/03/2017.
 */
public class SolutionTest {

    @Test
    public void testFindPoisonedDuration() throws Exception {
        System.out.println(new Solution().findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(new Solution().findPoisonedDuration(new int[]{1, 2}, 2));
    }
}