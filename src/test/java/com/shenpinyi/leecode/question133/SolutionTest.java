package com.shenpinyi.leecode.question133;

import com.shenpinyi.leecode.question412.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 27/03/2017.
 */
public class SolutionTest {

    @Test
    public void testCloneGraph() throws Exception {

        System.out.print(Solution.serialize(new Solution().cloneGraph(Solution.unserialize("0,1,2#1,2,3#2,2,3#3,2,1#"))));

    }
}