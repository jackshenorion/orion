package com.shenpinyi.hackerrank.strings.RichieRich;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        System.out.println(convert(number, k));
    }

    public static String convert(String number, int k) {
        char[] chars = number.toCharArray();
        int m = getMinimumSteps(chars);
        if (m > k) {
            return "-1";
        } else {
            changeNumber(chars, m, k);
            return new String(chars);
        }
    }

    public static int getMinimumSteps(char[] chars) {
        int m = 0;
        for (int i = 0; i < chars.length / 2; i ++) {
            int opposite = chars.length - i - 1;
            if (chars[i] != chars[opposite]) {
                m ++;
            }
        }
        return m;
    }

    public static void changeNumber(char[] chars, int min, int max) {
        for (int i = 0; i < chars.length / 2 ; i ++) {
            int opposite = chars.length - 1 - i;
            if (max <= 0) {
                return;
            }

            if (chars[i] != chars[opposite]) {
                if (max > min && (char) Math.max(chars[i], chars[opposite]) != '9') {
                    changeBothDigitAt(chars, i);
                    max = max - 2;
                    min = min - 1;
                } else {
                    changeDigitAt(chars, i);
                    max = max - 1;
                    min = min - 1;
                }
            } else { // same digit
                if (max >= min + 2 && (char) Math.max(chars[i], chars[opposite]) != '9') {
                    changeBothDigitAt(chars, i);
                    max = max - 2;
                }
            }
        }

        if (max > min) {
            changeMiddle(chars);
        }
    }

    public static void changeDigitAt(char[] chars, int index) {
        int opposite = chars.length - index - 1;
        char c = (char) Math.max(chars[index], chars[opposite]);
        chars[index] = chars[opposite] = c;
    }

    public static void changeBothDigitAt(char[] chars, int index) {
        int opposite = chars.length - index - 1;
        chars[index] = chars[opposite] = '9';
    }

    public static void changeMiddle(char[] chars) {
        if (chars.length % 2 != 0) {
            chars[chars.length / 2] = '9';
        }
    }
}