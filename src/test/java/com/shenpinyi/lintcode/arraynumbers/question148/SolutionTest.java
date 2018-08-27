package com.shenpinyi.lintcode.arraynumbers.question148;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sortColors() {

        int[] ints = {1, 0, 1, 2};
        new Solution().sortColors(ints);
        assertArrayEquals(new int[]{0,1,1,2}, ints);

    }
    @Test
    public void sortColors1() {

        int[] ints = {2,0,2,2,1,2,2,1,2,0,0,0,1};
        new Solution().sortColors(ints);
        assertArrayEquals(new int[]{0,0,0,0,1,1,1,2,2,2,2,2,2}, ints);

    }    @Test
    public void sortColors2() {

        int[] ints = {0,1,2,0,2,1,1,1,0,2,1,1,2,2,2,1};
        new Solution().sortColors(ints);
        assertArrayEquals(new int[]{0,0,0,1,1,1,1,1,1,1,2,2,2,2,2,2}, ints);

    }
}