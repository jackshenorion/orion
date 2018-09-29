package com.shenpinyi.lintcode.range.question30;

import com.shenpinyi.lintcode.range.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param intervals:   Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null) {
            intervals = Collections.EMPTY_LIST;
        }
        List<Interval> result = new ArrayList<>();
        boolean done = false;
        Interval toAdd = new Interval(newInterval.start, newInterval.end);

        for (Interval interval : intervals) {
            if (interval.end < toAdd.start) { //left
                result.add(interval);
            } else if (interval.start > toAdd.end) {
                if (!done) {
                    result.add(toAdd);
                    done = true;
                }
                result.add(interval);
            } else {
                toAdd.start = Math.min(interval.start, toAdd.start);
                toAdd.end = Math.max(interval.end, toAdd.end);
            }
        }
        if (!done) {
            result.add(toAdd);
        }
        return result;
    }
}

