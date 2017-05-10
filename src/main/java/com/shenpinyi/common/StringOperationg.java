package com.shenpinyi.common;

/**
 * Created by jack on 27/04/2017.
 */
public class StringOperationg {

    public static void run1() {
        /**
         * 以下代码用来遍历字符串中每个字符
         */
        String s = "aaabbccdeeff";
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            System.out.println(c);
        }
    }

    public static void main(String args[]) {
        run1();
    }

}
