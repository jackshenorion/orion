package com.shenpinyi.atlassian.kmp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void run() {
        assertEquals(15, new Solution().run("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
        assertEquals(15, new Solution().run("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));
        assertEquals(15, new Solution().run("ABC ABCDAB ABCDABCDABD", "ABCDABD"));
        assertEquals(-1, new Solution().run("ABC ABCDAB ABCDABCDAB", "ABCDABD"));
        assertEquals(0, new Solution().run("ABC ABCDAB ABCDABCDAB", "AB"));
        assertEquals(0, new Solution().run("ABC ABCDAB ABCDABCDAB", "ABC ABCDAB ABCDABCDAB"));
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 2},new Solution().getT("ABCDABD"));
    }
}