package com.shenpinyi.utils.bitwise;

/**
 * Created by jack on 30/03/2017.
 */
public class BitExample {
    public static void example1() {
        System.out.println("0       :" + Integer.toBinaryString(0));
        System.out.println("0<<1    :" + Integer.toBinaryString(0<<1));
        System.out.println("1       :" + Integer.toBinaryString(1));
        System.out.println("1<<1    :" + Integer.toBinaryString(1<<1));
        System.out.println("1<<31   :" + (1<<31));
        System.out.println("1<<31   :" + Integer.toBinaryString(1<<31));
        System.out.println("-1      :" + Integer.toBinaryString(-1));

        System.out.println("-2      :" + Integer.toBinaryString(-2));
        System.out.println("~1      :" + (~1));
        System.out.println("~1      :" + Integer.toBinaryString(~1));
        System.out.println("-~1      :" + (-~1));
        System.out.println("-~1      :" + Integer.toBinaryString(-~1));
        System.out.println("~-1      :" + (~-1));
        System.out.println("~-1      :" + Integer.toBinaryString(~-1));
        System.out.println("1<<1    :" + Integer.toBinaryString(1<<1));
    }


}
