package com.shenpinyi.common.bitwise;

/**
 * Created by jack on 3/05/2017.
 */
public class BitMapInteger {

    /**
     * 这这部分内容来自一道面试题,如果内存足够大,如何找到40亿个Integer整数中遗失的某个整数
     * 解法就是使用bit位来表示一个整数。如果这个整数出现就置对应bit位为1.当遍历完40个整数后,遍历bitmap看哪个位是0就可以了
     *
     * 那么构造bitmap,如何对这个bitmap置位呢,如何读取bitmap的值
     *
     * 我们使用最基本的单元int是32bit,所以一个int可以表示32个数。
     * 那么从0-31,就用第一个int
     * 32-64,用了第二个int
     */

    private static final int MinNumber = 0;
    private static final int MaxNumber = 16;
    private int[] bitmap = new int[Integer.MAX_VALUE / 4 + 2];
    public void setValue(int value) {
        bitmap[value >>> 5] |= (1 << (value & 0x1F));
        // value >> 5 是value除以32, 也就是这个数字在第几个32bit的int中。
        // value & 0x1F 是value除以32的余数,用来确定这个value是这个32一组数中的第几个数。
        // 1 << (value & 0x1F) 操作就是把对应的位置为1;
        // |= 就是把bitmap对应的位置1
    }

    public void clrValue(int value) {
        bitmap[value >>> 5] &= ~(1 << (value & 0x1F));
        // 和上面的setValue相反的操作
    }

    public boolean testValue(int value) {
        return (bitmap[value >>> 5] & (1 << (value & 0x1F))) != 0;
    }

    public static void main(String[] args) {
        BitMapInteger map = new BitMapInteger();
        map.setValue(1);
        map.setValue(-1);
        System.out.println(map.testValue(1));
        System.out.println(map.testValue(-1));
        System.out.println(map.testValue(2));
        System.out.println(map.testValue(-2));
        System.out.println(map.testValue(0));
    }
}
