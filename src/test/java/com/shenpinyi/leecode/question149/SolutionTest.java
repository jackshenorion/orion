package com.shenpinyi.leecode.question149;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 15/04/2017.
 */
public class SolutionTest {

    @Test
    public void testMaxPoints() throws Exception {
        System.out.println(
            new Solution().maxPoints(new Point[]{
                new Point(1, 5),
                new Point(1, 4),
                new Point(1, 3),
                new Point(2, 4),
                new Point(2, 5)
            })
        );

        System.out.println(
            new Solution().maxPoints(new Point[]{
                new Point(1, 1),
                new Point(1, 1),
                new Point(2, 3)
            })
        );

        System.out.println(
            new Solution().maxPoints(new Point[]{
                new Point(0, 0),
                new Point(0, 0)
            })
        );

        System.out.println(
            new Solution().maxPoints(new Point[]{
                new Point(0, 0),
                new Point(0, 0),
                new Point(0, 0)
            })
        );

        System.out.println(
            new Solution().maxPoints(new Point[]{
                new Point(0, 0),
                new Point(1, 1),
                new Point(1, -1)
            })
        );
    }
}