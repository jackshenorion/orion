package com.shenpinyi.cracking.bit.Introduction;

public class Solution {

    public static void main(String[] args) {
//        representInt();
//        representLong();
        basicBitOp();
//        bitGetSet();
//        shiftLeft();
        maskFromIToJ();
    }

    public static void representInt() {
        int a = 0b1101;
        System.out.println(String.format("%x", a)); // hexadecimal
        System.out.println(String.format("%o", a)); // octal integer
        System.out.println(Long.toBinaryString(a)); // binary
        System.out.println(a);
    }

    public static void representLong() {
        long b = 0b1101;
        System.out.println(String.format("%x", b)); // hexadecimal
        System.out.println(String.format("%o", b)); // octal integer
        System.out.println(Long.toBinaryString(b)); // binary
        System.out.println(b);
    }

    public static void basicBitOp() {
        System.out.println("======= basicBitOp");
        long a = 0b101101;
        System.out.println("去掉最后一位(101101->10110)" + Long.toBinaryString(a >>> 1));// 去掉最后一位          | (101101->10110)           | x shr 1
        System.out.println("在最后加一个0(101101->1011010)" + Long.toBinaryString(a << 1));// 在最后加一个0         | (101101->1011010)         | x shl 1
        System.out.println("在最后加一个1(101101->1011011)" + Long.toBinaryString((a << 1) + 1));// 在最后加一个1         | (101101->1011011)         | x shl 1+1
        System.out.println("把最后一位变成1(101100->101101)" + Long.toBinaryString(0b101100 | 1));// 把最后一位变成1       | (101100->101101)          | x or 1
        System.out.println("把最后一位变成0(101101->101100)" + Long.toBinaryString(a & (~1)));// 把最后一位变成0       | (101101->101100)          | x or 1-1
        System.out.println("最后一位取反(101101->101100)" + Long.toBinaryString(a ^ 1));// 最后一位取反          | (101101->101100)          | x xor 1
        // 注意下面的例子里面，右数第k位中的k从1开始，我们在其它地方，通常从0开始，这样和数组统一
        System.out.println("把右数第k位变成1(101001->101101,k=3)" + Long.toBinaryString(0b101001 | (1 << (3 - 1))));// 把右数第k位变成1      | (101001->101101,k=3)      | x or (1 shl (k-1))
        System.out.println("把右数第k位变成0(101101->101001,k=3)" + Long.toBinaryString(0b101101 & ~(1 << (3 - 1))));// 把右数第k位变成0      | (101101->101001,k=3)      | x and not (1 shl (k-1))
        System.out.println("右数第k位取反(101001->101101,k=3)" + Long.toBinaryString(0b101001 ^ (1 << (3 - 1))));// 右数第k位取反         | (101001->101101,k=3)      | x xor (1 shl (k-1))
        System.out.println("取末三位(1101101->101)" + Long.toBinaryString(0b1101101 & 0b111));// 取末三位              | (1101101->101)            | x and 7
        System.out.println("取末k位(1101101->1101,k=5)" + Long.toBinaryString(0b1101101 & ((1 << 5) - 1)));// 取末k位               | (1101101->1101,k=5)       | x and (1 shl k-1)
        System.out.println("取右数第k位(1101101->1,k=4)" + Long.toBinaryString((0b11011101 >>> (4 - 1)) & 1));// 取右数第k位           | (1101101->1,k=4)          | x shr (k-1) and 1
        System.out.println("把末k位变成1(101001->101111,k=4)" + Long.toBinaryString(0b101001 | ((1 << 4) - 1)));// 把末k位变成1          | (101001->101111,k=4)      | x or (1 shl k-1)
        System.out.println("把末k位变成1(101001->101111,k=32)" + Long.toBinaryString(0b101001 | ~0));// 因为左移32位相当于不移动，因此需要对32的情况特别处理
        System.out.println("末k位取反(101001->100110,k=4)" + Long.toBinaryString(0b101001 ^ ((1 << 4) - 1)));// 末k位取反             | (101001->100110,k=4)      | x xor (1 shl k-1)
        System.out.println("把右边连续的1变成0(100101111->100100000)" + Long.toBinaryString(0b100101111 & (0b100101111 + 1)));// 把右边连续的1变成0    | (100101111->100100000)    | x and (x+1)
        System.out.println("把右起第一个0变成1(100101111->100111111)" + Long.toBinaryString(0b100101111 | (0b100101111 + 1)));// 把右起第一个0变成1    | (100101111->100111111)    | x or (x+1)
        System.out.println("把右边连续的0变成1(11011000->11011111)" + Long.toBinaryString(0b11011000 | (0b11011000 - 1)));// 把右边连续的0变成1    | (11011000->11011111)      | x or (x-1)
        System.out.println("取右边连续的1(100101111->1111)" + Long.toBinaryString((0b100101111 ^ (0b100101111 + 1)) >> 1));// 取右边连续的1         | (100101111->1111)         | (x xor (x+1)) shr 1
        System.out.println("去掉右起第一个1的左边(100101000->1000)" + Long.toBinaryString((0b100101000 ^ (0b100101000 - 1)) & 0b100101000));// 去掉右起第一个1的左边 | (100101000->1000)         | x and (x xor (x-1))
    }

    public static void bitGetSet() {
        System.out.println("======= bitGetSet");
        System.out.println("Get 从右数第k位(101100->true, k=3)" +((0b101100 & (1 << (3 - 1))) != 0));  //Get操作判断是否为0
        System.out.println("Set 从右数第k位(101100->111100, k=5)" + Long.toBinaryString(0b101100 | (1 << (5 - 1)))); //Set操作使用 or操作
        System.out.println("Clear 从右数第k位(101100->100100, k=4)" + Long.toBinaryString(0b101100 & ~(1 << (4 - 1)))); //Clear操作使用 and操作
    }

    /**
     * 构造从右数第i位到第j位都为1，其它都为0的integer
     */

    public static void shiftLeft() {
        for (int i = 0; i <= 32; i ++) {
            System.out.println(Integer.toBinaryString(1 << i));
        }
        for (int i = 0; i <= 32; i ++) {
            System.out.println(Integer.toBinaryString((~0) << i));
        }
        System.out.println("Left shift wind up test, a << b is a << (b % 32), 1101_0010 << 32 is itself: " + Integer.toBinaryString(0b1101_0010 << 32));
    }


    public static void maskFromIToJ() {
        System.out.println(Integer.toBinaryString(fromIToJHelper(-1,-1))); // 0
        System.out.println(Integer.toBinaryString(fromIToJHelper(0,0))); // 1
        System.out.println(Integer.toBinaryString(fromIToJHelper(1,1))); // 10
        System.out.println(Integer.toBinaryString(fromIToJHelper(1,6))); // 111_1110
        System.out.println(Integer.toBinaryString(fromIToJHelper(0,31))); // 11111...1111
        System.out.println(Integer.toBinaryString(fromIToJHelper(1,31))); // 11111...1110

        System.out.println(Integer.toBinaryString(fromIToJHelperB(-1,-1))); // 0
        System.out.println(Integer.toBinaryString(fromIToJHelperB(0,0))); // 1
        System.out.println(Integer.toBinaryString(fromIToJHelperB(1,1))); // 10
        System.out.println(Integer.toBinaryString(fromIToJHelperB(1,6))); // 111_1110
        System.out.println(Integer.toBinaryString(fromIToJHelperB(0,31))); // 11111...1111
        System.out.println(Integer.toBinaryString(fromIToJHelperB(1,31))); // 11111...1110
    }

    public static int fromIToJHelper(int i, int j) {
        // i = -1, j = -1: 0000
        // i = 0, j = 0: 0001 (1111 & 0001)
        // i = 0, j = 3: 1111 (1111 & 1111)
        // i = 1, j = 2: 0110 (1110 & 0111)
        // i = 1, j = 3: 1110 (1110 & 1111)
        // i = 3, j = 3: 1000 (1000 & 1111)
        int allOnes = ~0;
        if (i > j || i < 0) {
            return 0;
        }
        // i: from i to end, all 1
        int left = allOnes << i;
        // j: from 0 to j, all 1
        // 因为要left shift j + 1，也就是可能会shift 32，因此，我们要处理wind up的情况，也就是当left shift 32的时候，结果不是0，而是等于原数字
        int right = j == 31 ? ~0 : ~(allOnes << (j + 1));
        return left & right;
    }

    public static int fromIToJHelperB(int i, int j) {
        // 另外一种方式是构造长度为j - i + 1的1s，然后在左移i次，这个解法更加直观简单，不过还是要处理长度为32的特殊情况
        if (i > j || i < 0) {
            return 0;
        }
        int len = j - i + 1;
        int mask = len == 32 ? ~0 : (1 << len) - 1;
        return mask << i;
    }
}
