package com.shenpinyi.hackerrank.online.question5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jack on 2/05/2017.
 */
public class Solution {
    static String reproduceString(String input) {
        Set<Character> vowels = getVowels();
        String output = getNonVowelString(vowels, input);
        return output.length() == 0 ? "-" : output;
    }

    static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('A','a','E','e','I','i','O','o','U','u'));
        return vowels;
    }

    static String getNonVowelString(Set<Character> vowels, String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i ++) {
            char c = input.charAt(i);
            if (vowels.contains(c)) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.print(reproduceString("Identity"));
    }

}
