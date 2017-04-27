package com.shenpinyi.javaUtils.operators;

/**
 * Created by jack on 26/04/2017.
 */
public class Operators {
    public static void run() {
        Double d = Double.NaN;
        System.out.println(d);
        System.out.println(d.toString());
        System.out.println(d / d);
//        System.out.println(0 / 0); //java.lang.ArithmeticException: / by zero
//        System.out.println(1 / 0); //java.lang.ArithmeticException: / by zero
        System.out.println(1.0 / 0.0);
    }

    public static void run2() {
        System.out.println(Character.MAX_VALUE);
        System.out.println(Short.MAX_VALUE); //32767
        System.out.println(Integer.MAX_VALUE); //2147483647
        System.out.println(Long.MAX_VALUE); //9223372036854775807
        System.out.println(Float.MAX_VALUE); //3.4028235E38
        System.out.println(Double.MAX_VALUE); //1.7976931348623157E308
    }

    public static void run3() {
        System.out.print(1 + 2 + 3 + " "); // 6
        System.out.print(" " + 1 + 2 + 3); // 123
        // 可以看出,运算是自左向右运行的
    }

    public static void run4() {
        int x = 0x80000000;
        int y = 0x80000000;
        System.out.print(x + " and  ");
        x = x >>> 31;
        System.out.print(x); // 无符号右移位就是符号位也一起右移
        System.out.print(" and " + Integer.toBinaryString(x)); //1
        y = y >> 31;
        System.out.print(" and " + y); // 带符号右移位就是不管符号位, 右移过程中前补1
        System.out.print(" and " + Integer.toBinaryString(y)); //11111111111111111111111111111111
    }

}
