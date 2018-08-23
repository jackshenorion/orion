package com.shenpinyi.lintcode.arraynumbers.question138;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void subarraySum() {

        System.out.print(new Solution().subarraySum(new int[]{-3,1,2,-3,4}));
        System.out.print(new Solution().subarraySum(new int[]{-5,10,5,-3,1,1,1,-2,3,-4}));

    }
}