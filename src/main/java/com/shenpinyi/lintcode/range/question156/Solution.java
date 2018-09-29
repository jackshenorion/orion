package com.shenpinyi.lintcode.range.question156;

import com.shenpinyi.lintcode.range.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null) {
            return null;
        }
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        List<Interval> result = new ArrayList<>();
        Interval lastInterval = null;
        for (Interval interval : intervals) {
            Interval toAdd = new Interval(interval.start, interval.end);
            if (lastInterval == null) {
                result.add(toAdd);
                lastInterval = toAdd;
            } else {
                if (lastInterval.end < toAdd.start) {
                    result.add(toAdd);
                    lastInterval = toAdd;
                } else {
                    lastInterval.end = Math.max(lastInterval.end, toAdd.end);
                }
            }
        }
        return result;
    }
}
