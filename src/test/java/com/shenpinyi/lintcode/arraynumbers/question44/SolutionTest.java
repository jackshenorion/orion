package com.shenpinyi.lintcode.arraynumbers.question44;

import com.shenpinyi.javaUtils.array.Arrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minSubArray() {
        assertEquals(-3, new Solution().minSubArray(java.util.Arrays.asList(1, -1, -2, 1)));
    }
}