package com.shenpinyi.leecode.question60;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 27/03/2017.
 */
public class SolutionTest {

    @Test
    public void testGetPermutation() throws Exception {
        System.out.println(new Solution().getPermutation(4, 0));
        System.out.println(new Solution().getPermutation(4, 1));
        System.out.println(new Solution().getPermutation(4, 2));
        System.out.println(new Solution().getPermutation(4, 3));
        System.out.println(new Solution().getPermutation(4, 4));
        System.out.println(new Solution().getPermutation(4, 5));
        System.out.println(new Solution().getPermutation(4, 6));
        System.out.println(new Solution().getPermutation(9, 100));
    }
}