package com.shenpinyi.other.tripadviser;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void braces() {
        assertArrayEquals(new String[]{"YES", "NO"}, Solution2.braces(new String[]{"{aaa}ddd[bbb](ddd)",
                "{aaa[bbb}ddd]eeee}"}));
    }
}