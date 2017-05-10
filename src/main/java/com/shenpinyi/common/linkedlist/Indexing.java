package com.shenpinyi.common.linkedlist;

import java.util.ArrayList;

/**
 * Created by jack on 4/05/2017.
 */
public class Indexing {

    /**
     * 一个最简单的合并两个ArrayList
     */

    //解法1: 比较传统,就是一个一个加到新的list中
    ArrayList<String> merge(ArrayList<String> words, ArrayList<String> more) {
        ArrayList<String> output = new ArrayList<>(words.size() + more.size());
        for (String s : words) {
            output.add(s);
        }
        for (String s : more) {
            output.add(s);
        }
        return output;
    }

    //解法2: 本质上和解法1相同,但是使用了ArrayList的addAll方法
    //其实在addAll中是通过将list变成数组,然后使用System.arraycopy来填充数据的
    ArrayList<String> merge01(ArrayList<String> words, ArrayList<String> more) {
        ArrayList<String> output = new ArrayList<>(words.size() + more.size());
        output.addAll(words);
        output.addAll(more);
        return output;
    }


}
