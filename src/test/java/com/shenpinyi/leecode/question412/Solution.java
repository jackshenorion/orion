package com.shenpinyi.leecode.question412;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {

        int i = 1;
        int j = 1, k = 1, m = 1;
        List<String> output = new ArrayList<>();

        while (i <= n) {
            if (m == 15) {
                output.add("FizzBuzz");
                m = 1;
                j = 1;
                k = 1;
            } else if (k == 5) {
                output.add("Buzz");
                k = 1;
                m ++;
                j ++;
            } else if (j == 3) {
                output.add("Fizz");
                j = 1;
                k ++;
                m ++;
            } else {
                output.add(i + "");
                j++;
                k++;
                m++;
            }
            i ++;
        }

        return output;
    }
}