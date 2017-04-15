package com.shenpinyi.leecode.question502;

import java.util.*;

/**
 * Created by jack on 13/04/2017.
 */
public class Solution {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int count = 0;
        int wall = 0;
        int previousWall = 0;
        int w = W;
        PriorityQueue<Integer> profitQueue = new PriorityQueue<>(Profits.length, new CompProfit());
        while (count < k) {
            if (wall <= Capital.length - 1) {
                previousWall = wall;
                wall = quickSelect(Capital, Profits, wall, Capital.length - 1, w);
                while (previousWall < wall) {
                    profitQueue.offer(Profits[previousWall]);
                    previousWall ++;
                }
            }
            if (profitQueue.size() == 0) {break;}
            w += profitQueue.poll();
            count ++;
        }
        return w;
    }

    private int quickSelect(int[] a, int b[], int low, int high, int pivot) {
        int wall = low;
        for (int i = 0; i < high - low + 1; i ++) {
            if (a[low + i] <= pivot) {
                swap(a, wall, low + i);
                swap(b, wall, low + i);
                wall ++;
            }
        }
        return wall;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    class CompProfit implements Comparator<Integer> {
        public int compare(Integer p1, Integer p2){
            return Integer.compare(p2, p1);
        }
    }

//    List<Integer> merge(List<Integer> group1, List<Integer> group2, int k) {
//        List<Integer> merged = new ArrayList<>(Math.min(k, group1.size() + group2.size()));
//        int count = 0;
//        while (count < k && group1.size() != 0 && group2.size() != 0) {
//            if (group1.get(0) > group2.get(0)) {
//                merged.add(group1.remove(0));
//                count ++;
//            } else {
//                merged.add(group2.remove(0));
//                count ++;
//            }
//        }
//
//        while (count < k && group1.size() != 0) {
//            merged.add(group1.remove(0));
//            count ++;
//        }
//
//        while (count < k && group2.size() != 0) {
//            merged.add(group2.remove(0));
//            count ++;
//        }
//
//        return merged;
//    }

//    class CapitalGroup {
//        public int capital;
//        public List<Integer> group;
//        public CapitalGroup(int capital, List<Integer> group) {
//            this.capital = capital;
//            this.group = group;
//        }
//    }

//    }

    //    class CompCapitalGroup implements Comparator<CapitalGroup> {
//        public int compare(CapitalGroup p1, CapitalGroup p2){
//            return Integer.compare(p1.capital, p2.capital);
//        }

}
