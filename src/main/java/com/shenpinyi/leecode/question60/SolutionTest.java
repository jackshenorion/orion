package com.shenpinyi.leecode.question60;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 27/03/2017.
 */
public class SolutionTest {

    @Test
    public void testGetPermutation() throws Exception {
        System.out.println(new Solution().getPermutation(3, 0));
        System.out.println(new Solution().getPermutation(3, 1));
        System.out.println(new Solution().getPermutation(3, 2));
        System.out.println(new Solution().getPermutation(3, 3));
        System.out.println(new Solution().getPermutation(3, 4));
        System.out.println(new Solution().getPermutation(3, 5));
        System.out.println(new Solution().getPermutation(3, 6));
        System.out.println(new Solution().getPermutation(9, 100));
    }
}