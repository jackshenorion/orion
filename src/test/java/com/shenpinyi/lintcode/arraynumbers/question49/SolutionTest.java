package com.shenpinyi.lintcode.arraynumbers.question49;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sortLetters() {
        char[] chars = "abAcD".toCharArray();
        new Solution().sortLetters(chars);
        assertArrayEquals("abcAD".toCharArray(), chars);
    }
}