package com.shenpinyi.hackerrank.common;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jack on 27/04/2017.
 */
public class StdioOperation {

    public static void run() {
        /**
         * Scanner 是从java5开始支持的输入类,所以对System.in.read的替代
         */

        /**
         * 以下例子是从Stdin输入一行数据
         */
        System.out.print("Please input, press return to end: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        /**
         * 我们从下面的输出可以看出,输入中不包含回车换行字符
         *
         * Please input, press return to end: abcd
         * 97 98 99 100
         */
        for (int i = 0; i < s.length(); i ++) {
            System.out.print((int) s.charAt(i) + " ");
        }
    }



    public static void run1() {
        try {
            int c;
            while ((c = System.in.read()) != '\n') {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        run();
    }
}
