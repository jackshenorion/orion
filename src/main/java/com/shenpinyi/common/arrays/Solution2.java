package com.shenpinyi.common.arrays;

/**
 * Created by jack on 4/05/2017.
 */
public class Solution2 {

    //给两个字符串,判断一个是否是另外一个的排列组合
    //这类有限字符编码的排列等同问题,其实通常都是用数组解决。如果不用计次,用boolean数组甚至是位图都能表示
    //其实这个数据也就是这个字符串的一个签名
    //另外,注意澄清是否区分大小写

    public boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i ++) {
            count[s.charAt(i)] ++;
            count[t.charAt(i)] --;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }



}
