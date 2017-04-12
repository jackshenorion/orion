package com.shenpinyi.leecode.question56;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jack on 11/04/2017.
 */
public class SolutionTest {

    @Test
    public void testMerge() throws Exception {
        List<Interval> output = new Solution().merge(Arrays.asList(
            new Interval(1,4),
            new Interval(2,3)
        ));
        output.forEach(e -> System.out.println("[" + e.start+ "," + e.end + "]"));
    }
}