package com.shenpinyi.common.arrays;

/**
 * Created by jack on 4/05/2017.
 */
public class Solution1 {


    //这道题是问怎么判断一个字符串中的所有字符的都是唯一的,也就是没有重复的字符
    //一个最简单的办法是使用boolean数组
    // 但是首先确定这个字符是ascii还是别的什么编码方式,这样会影响到boolean数组的大小。通常都是ascii码
    //另外,根据鸽巢理论,如果字符串长度大于字符编码的个数,那么肯定也是会有重复的
    public boolean isUnique(String str) {

        if (str.length() > 256) {
            return false;
        }

        boolean[] check = new boolean[256];
        for (int i = 0; i < str.length(); i ++) {
            if (check[str.charAt(i)]) {
                return false;
            } else {
                check[str.charAt(i)] = true;
            }
        }
        return true;
    }

}
