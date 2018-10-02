package com.shenpinyi.other.tripadviser;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void calculateLargest() {
        assertEquals(2, Solution.calculateLargest(2));
        assertEquals(0, Solution.calculateLargest(1));
        assertEquals(7, Solution.calculateLargest(15));
        assertEquals(89, Solution.calculateLargest(100));
    }
}