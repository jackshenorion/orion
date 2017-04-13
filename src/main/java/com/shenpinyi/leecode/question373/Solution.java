package com.shenpinyi.leecode.question373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jack on 12/04/2017.
 */
public class Solution {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        List<int[]> output = new ArrayList<>(k);
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return output;
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new CompPair()); // use new CompPair instead of java8 syntax reduce from 80ms to 2ms
        for (int i = 0; i < nums1.length && i < k; i ++) {
            queue.offer(new Node(nums1[i], nums2[0], 0));
        }

        while (count < k) {
            Node next = queue.poll();
            count ++;
            if (next == null) {break;}
            output.add(next.pair);
            if (next.idx_y < nums2.length - 1) {
                queue.offer(new Node(next.pair[0], nums2[next.idx_y + 1], next.idx_y + 1));
            }
        }
        return output;
    }

    class CompPair implements Comparator<Node> {
        public int compare(Node p1, Node p2){
            return Integer.compare(p1.sum, p2.sum);
        }
    }

    static class Node {
        public int[] pair;
        public int idx_y;
        public int sum;
        public Node (int x, int y, int idx_y) {
            this.pair = new int[]{x, y};
            this.idx_y = idx_y;
            this.sum = x + y;
        }
    }

    public List<int[]> kSmallestPairs_33(int[] nums1, int[] nums2, int k) {
        int count = 0;
        List<int[]> output = new ArrayList<>(k);
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return output;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < nums1.length && i < k; i ++) {
            queue.add(new int[]{i, 0});
        }

        while (count < k) {
            int[] pair = queue.poll();
            count ++;
            if (pair == null) {break;}
            output.add(new int[]{nums1[pair[0]], nums2[pair[1]]});
            if (pair[1] < nums2.length - 1) {
                queue.add(new int[]{pair[0], pair[1] + 1});
            }
        }
        return output;
    }

    public List<int[]> kSmallestPairs_30(int[] nums1, int[] nums2, int k) {
        int count = 0;
        List<int[]> output = new ArrayList<>(k);
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return output;
        }
        PriorityQueue<Node_A> queue = new PriorityQueue<Node_A>((o1, o2) -> o1.sum() - o2.sum());
        for (int i = 0; i < nums1.length && i < k; i ++) {
            queue.add(new Node_A(nums1[i], nums2[0], i, 0));
        }

        while (count < k) {
            Node_A pair = queue.poll();
            count ++;
            if (pair == null) {break;}
            output.add(new int[]{pair.x, pair.y});
            if (pair.idx_y < nums2.length - 1) {
                queue.add(new Node_A(nums1[pair.idx_x], nums2[pair.idx_y + 1], pair.idx_x, pair.idx_y + 1));
            }
        }
        return output;
    }

    static class Node_A {
        public int x;
        public int y;
        public int idx_x;
        public int idx_y;
        public Node_A (int x, int y, int idx_x, int idx_y) {
            this.x = x;
            this.y = y;
            this.idx_x = idx_x;
            this.idx_y = idx_y;
        }
        public int sum() {return x + y;}
    }
}
