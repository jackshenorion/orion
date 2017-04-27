package com.shenpinyi.javaUtils.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jack on 26/04/2017.
 */
public class ConcurrencyTest {

    @Test
    public void testRun1() throws Exception {
        Concurrency.run1();
        Concurrency.run2();
        Concurrency.run3();
    }
}