package com.shenpinyi.leecode.question77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jack on 15/04/2017.
 */
public class Solution {
    /**
     * 只要掌握基本的概率知识,注意题目是组合,不是排列。另外,使用LinkedList比ArrayList更加适合这类往链表中插入记录而非随机访问的场景。
     * 本实现超过了85%的提交。
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || k > n) {
            return new LinkedList<>();
        }
        return combine(1, n, k);
    }

    private List<List<Integer>> combine(int start, int end, int k) {
        List<List<Integer>> output = new LinkedList<>();
        for (int i = start; i <= end - k + 1; i ++) {
            if (k == 1) {
                List<Integer> e = new LinkedList<>();
                e.add(i);
                output.add(e);
            } else {
                List<List<Integer>> subOutput = combine(i + 1, end, k - 1);
                for (List<Integer> e : subOutput) {
                    e.add(0, i);
                }
                output.addAll(subOutput);
            }
        }
        return output;
    }
}
