package com.shenpinyi.common.arrays;

/**
 * Created by jack on 4/05/2017.
 */
public class Solution6 {

    //这个问题是把一个形如aabcccccaaa压缩成a2b1c5a3这样的形式。当然如果压缩后的长度没减少,那么就还是返回原字符串
    //为了尽快结束,那么就在操作的过程中查看是否长度已经超过了
    //另外使用StringBuilder应该会效率更高一点,如果stringBuilder有长度方法
    //另外,这里还考察了一个遍历数组的重复数据的算法


    public String compress(String str) {

        StringBuilder sb = new StringBuilder(str.length());
        int count = 0;
        for (int i = 0; i < str.length(); i ++) {
            if (i != 0 && (str.charAt(i) == str.charAt(i - 1))) {
                //重复数据
                count ++;
            } else {
                if (count != 0) {
                    sb.append(count);
                }
                sb.append(str.charAt(i));
                count = 1;
            }
        }
        if (sb.length() >= str.length()) {
            return str;
        } else {
            return sb.toString();
        }
    }

}
