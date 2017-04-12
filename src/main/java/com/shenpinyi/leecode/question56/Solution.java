package com.shenpinyi.leecode.question56;

/**
 * Created by jack on 11/04/2017.
 */

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {return intervals;}
        intervals.sort((o1, o2) -> o1.start - o2.start);
        List<Interval> b = new ArrayList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); i ++) {
            Interval current = intervals.get(i);
            if (current.start <= end) {
                end = Math.max(current.end, end);
            } else {
                b.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        b.add(new Interval(start, end));
        return b;
    }
}