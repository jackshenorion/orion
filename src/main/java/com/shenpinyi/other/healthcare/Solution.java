package com.shenpinyi.other.healthcare;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by jack on 14/06/2017.
 */
public class Solution {

    public static int kthMostCommon(int[] a, int k) {
        Map<Integer, Integer> statistic = getStatistic(a);
        if (k > statistic.size()) {
            return -1;
        }
        return getKthFrequency(statistic, k);
    }

    static Map<Integer, Integer> getStatistic(int[] frequency) {
        Map<Integer, Integer> statics = new HashMap<>();
        for (int count : frequency) {
            increaseFrequency(statics, count);
        }
        return statics;
    }

    static void increaseFrequency(Map<Integer, Integer> statistic, int num) {
        if (statistic.get(num) == null) {
            statistic.put(num, 1);
        } else {
            statistic.put(num, statistic.get(num) + 1);
        }
    }

    static int getKthFrequency(Map<Integer, Integer> statistic, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry : statistic.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.remove().getKey();
    }

    public static void main(String[] args) {
        int x = kthMostCommon(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }


}
