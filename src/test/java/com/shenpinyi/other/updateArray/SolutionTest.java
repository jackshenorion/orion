package com.shenpinyi.other.updateArray;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void updateArray() {

        String[][] a = new String[][]{
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"}
        };
        String[][] b = new String[][]{
                {"d", "e", "y"},
                {"a", "b", "x"},
                {"g", "h", "i"}
        };
        new Solution().updateArray(a, b);
        assertArrayEquals(
                new String[][]{
                        {"a", "b", "x"},
                        {"d", "e", "y"},
                        {"g", "h", "i"}},
                a);
    }
}