package com.shenpinyi.common;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jack on 27/04/2017.
 */
public class StdioOperation {

    public static void run() {
        /**
         * Scanner 是从java5开始支持的输入类,所以对System.in.read的替代
         * 事实上,每次用户输入回车的时候,console就会将这行字符送到输入流中,而不是每敲击一个键就发送一个字符。
         * Scanner收到输入后会对输入处理。如果是nextInt
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

    public static void run01() {
        /**
         * Scanner 类可以用来输入int数字
         */
        System.out.print("Please input a number:");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            System.out.println("The number you've input is " + sc.nextInt());
        } else {
            System.out.println("You're not inputting number.");
        }
    }

    public static void run02() {
        /**
         * Scanner 类可以用来输入int数字
         */

        /**
         * 如果用户输入的不是int,那么事实上,hasNextInt就是false,这个时候强行用nextInt就会抛出异常
         * Please input a number:eee23
         Exception in thread "main" java.util.InputMismatchException
         */
        System.out.print("Please input a number:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("The number you've input is " + a);
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
        run02();
    }
}
