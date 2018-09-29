package com.shenpinyi.lintcode.range.question30;

import com.shenpinyi.lintcode.range.Interval;
import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {

    @Test
    public void insert() {
        System.out.println(new Solution().insert(new ArrayList<>(), new Interval(5,7)));
    }
}