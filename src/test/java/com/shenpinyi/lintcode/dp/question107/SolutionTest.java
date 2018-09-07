package com.shenpinyi.lintcode.dp.question107;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void wordBreak() {

        HashSet<String> dic = new HashSet<>();
        dic.add("lint");
        dic.add("code");
        assertTrue(new Solution().wordBreak("lintcode", dic));
    }

    @Test
    public void wordBreak2() {

        HashSet<String> dic = new HashSet<>();
        dic.add("lint");
        dic.add("code");
        assertFalse(new Solution().wordBreak("lintcode1", dic));
    }
}