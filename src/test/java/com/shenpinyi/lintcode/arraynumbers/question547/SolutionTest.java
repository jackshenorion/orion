package com.shenpinyi.lintcode.arraynumbers.question547;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void intersection() {

        int[] intersection = new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int num : intersection) {
            System.out.print(num);
        }


    }

    @Test
    public void intersectionB() {

        int[] intersection = new Solution().intersectionB(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int num : intersection) {
            System.out.print(num);
        }


    }
}