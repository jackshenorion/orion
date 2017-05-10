package com.shenpinyi.common.arrays;

/**
 * Created by jack on 4/05/2017.
 */
public class Solution3 {

    //这道题是替换字符串中的所有空格为%20, 假设字符数组的长度足够长, trueLength给的是实际字符串的长度
    //思路是为了避免频繁的移动数组中的字符,从尾部开始填充替换后的字符,这样就需要知道替换后的长度是多少
    //这个比较好办,就是数下有多少个空格计算下就可以了

    public void replaceSpace(char[] str, int trueLength) {
        int newLength = trueLength;
        for (int i = 0; i < trueLength; i ++) {
            if (str[i] == ' ') {
                newLength += 2;
            }
        }
        str[trueLength] = '\0';
        int nextIndex = newLength - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            char c = str[i];
            if (c == ' ') {
                str[nextIndex] = '0';
                str[nextIndex - 1] = '2';
                str[nextIndex - 2] = '%';
                nextIndex -= 3;
            } else {
                str[nextIndex] = c;
                nextIndex --;
            }
        }
    }
}
