package com.shenpinyi.leecode.question392;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jack on 16/04/2017.
 */

/**
 * 以下算法击败了65%的提交。看到论坛中的最佳提交中,大部分都没有考虑followup,采用了最直接的两个指针遍历的方法。
 * 而下面这个解法主要针对的是followup,因为有很多个s,所以最好不要每次都扫描一遍t,因此,将t中每个字符出现的位置,保存在list中,然后执行binarySearch。
 * 我尝试了使用TreeSet保存位置,但是memory超过限制了。但是,即便内存没有超过限制,TreeSet一定是个比较好的选择吗? 答案是不一定。
 * 个人觉得,对于这种索引数据的插入是按照大小顺序一次构造完成的,后续只是查找,那么就需要用ArrayList就可以了。这样构建的过程是O(N),而不是O(NlogN)。
 * 查找排好序的数组的速度和TreeSet是一样的,都是O(logN)。
 *
 */

public class Solution {
    private Stat stat = null;

    public boolean isSubsequence(String s, String t) {
        if (stat == null) {
            stat = new Stat(t);
        }
        int from = 0;
        for (int i = 0; i < s.length(); i ++) {
            from = stat.find(s.charAt(i), from);
            if (from == -1) {
                return false;
            }
            from ++;
        }
        return true;
    }

    class Stat {
        private List<ArrayList<StatItem>> stat = null;

        public Stat(String t) {
            stat = new ArrayList<>(26);
            for (int i = 0; i < 26; i ++) {
                stat.add(new ArrayList<>(100));
            }

            StatItem preItem = null;
            char preChar = 0;
            for (int i = 0; i < t.length(); i ++) {
                char currentChar = t.charAt(i);
                ArrayList<StatItem> charStat = stat.get(currentChar - 'a');
                StatItem currentItem = null;
                if (preChar == 0 || preChar != currentChar) {
                    currentItem = new StatItem(i, i);
                    charStat.add(currentItem);
                    preItem = currentItem;
                    preChar = currentChar;
                    continue;
                } else {
                    preItem.end = i;
                }
            }
        }

        public int find(char c, int from) {
            return find(stat.get(c - 'a'), from, 0, stat.get(c - 'a').size() - 1);
        }

        public int find(ArrayList<StatItem> charStat, int from, int start, int end) {
            if (start > end) {return -1;}
            if (charStat.get(start).end >= from) {return Math.max(from, charStat.get(start).start);}
            if (charStat.get(end).end < from) {return -1;}
            int mid = (start + end) >> 1;
            int midStart = charStat.get(mid).start;
            int midEnd = charStat.get(mid).end;
            if (from >= midStart && from <= midEnd) {
                return from;
            } else if (midEnd < from) {
                return find(charStat, from, mid + 1, end);
            } else {
                return find(charStat, from, start + 1, mid);
            }
        }
    }

    class StatItem {
        int start;
        int end;
        public StatItem(int a, int b) {start = a; end = b;}
    }
}
