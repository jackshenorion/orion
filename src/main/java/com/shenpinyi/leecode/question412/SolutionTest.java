package com.shenpinyi.leecode.question412;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jack on 26/03/2017.
 */
public class SolutionTest {

    @Test
    public void testFizzBuzz() throws Exception {
        new Solution().fizzBuzz(3).forEach(item -> System.out.print(item + " "));
        System.out.println("\n");
        new Solution().fizzBuzz(5).forEach(item -> System.out.print(item + " "));
        System.out.println("\n");
        new Solution().fizzBuzz(15).forEach(item -> System.out.print(item + " "));
        System.out.println("\n");
        new Solution().fizzBuzz(0).forEach(item -> System.out.print(item + " "));
        System.out.println("\n");
        new Solution().fizzBuzz(1).forEach(item -> System.out.print(item + " "));
        System.out.println("\n");
        new Solution().fizzBuzz(30).forEach(item -> System.out.print(item + " "));
        System.out.println("\n");
    }
}