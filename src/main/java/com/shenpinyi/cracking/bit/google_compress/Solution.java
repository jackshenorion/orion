package com.shenpinyi.cracking.bit.google_compress;

public class Solution {

    public void encode(long n) {
        long rest = n;
        System.out.println(n + ":");
        for (int i = 0; i < 10; i++) {
            long segment = rest & 0b01111111;
            if (rest - segment == 0) {
                segment |= 0b10000000;
                System.out.println(Long.toBinaryString(segment));
                break;
            } else {
                System.out.println(Long.toBinaryString(segment));
            }
            rest = rest >>> 7;
        }

    }

    public void decode(byte[] bytes) {
        long result = 0;
        for (int i = 0; i < bytes.length; i++) {
            byte current = bytes[i];
            if ((current & (1 << 7)) == 0) {
                result |= current << (i * 7);
            } else {
                result |= (current & 0b111_1111) << (i * 7);
                break;
            }

        }
        System.out.println(Long.toBinaryString(result));

    }

    public static void main(String[] args) {
        new Solution().encode(0b1000_1000010_1001010_1001010);
        new Solution().encode(0b0);
        new Solution().encode(0b100);
        new Solution().encode(Long.MAX_VALUE);
        new Solution().encode(-1);


        new Solution().decode(new byte[]{
                0b1111111,
                0b1111111,
                0b1111111,
                0b1111111,
                0b1111111,
                0b1111111,
                0b1111111,
                0b1111111,
                (byte) 0b11111111,
        });

        new Solution().decode(new byte[]{
                0b1001010,
                0b1001010,
                0b1000010,
                (byte) 0b10001000
        });
        new Solution().decode(new byte[]{
                (byte) 0b10000000,
                (byte) 0b10000000
        });
    }

}
