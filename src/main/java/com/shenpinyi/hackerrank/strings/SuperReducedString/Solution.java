package com.shenpinyi.hackerrank.strings.SuperReducedString;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jack on 27/04/2017.
 */
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.size() == 0) {
            System.out.println("Empty String");
        } else {
            char[] output = new char[stack.size()];
            int i = stack.size() - 1;
            while (!stack.empty()) {
                output[i--] = stack.pop();
            }
            System.out.println(new String(output));
        }

    }
}
