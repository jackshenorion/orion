package com.shenpinyi.leecode.question334;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 1/04/2017.
 */
public class SolutionTest {

    @Test
    public void testIncreasingTriplet() throws Exception {
        System.out.println(new Solution().increasingTriplet(new int[] {100, 50, 99, 49, 98, 48, 97, 47}));
        System.out.println(new Solution().increasingTriplet(new int[] {100, 50, 99, 49, 98, 48, 100, 47}));
        System.out.println(new Solution().increasingTriplet(new int[] {5, 4, 3, 2, 1}));
        System.out.println(new Solution().increasingTriplet(new int[] {1, 2, 3, 4, 5}));
    }
}