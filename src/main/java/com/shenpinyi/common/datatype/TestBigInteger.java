package com.shenpinyi.common.datatype;

import java.math.BigInteger;

/**
 * Created by jack on 7/05/2017.
 */
public class TestBigInteger {
    public static void run() {
        BigInteger b = BigInteger.ZERO;
        b = b.add(BigInteger.valueOf(Integer.MAX_VALUE));
        b = b.add(BigInteger.valueOf(Integer.MAX_VALUE));
        System.out.println(b.toString());
    }

    public static void main(String[] args) {
        run();
    }

}
