package com.shenpinyi.leecode.question218;

import java.util.*;

/**
 * Created by jack on 17/04/2017.
 */
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> a = discrete(buildings);

        Node[] segmentTree = new Node[a.size() * 4];
        buildSegmentTree(segmentTree, 0, a.size() - 1, 0);

        for (int i = 0; i < buildings.length; i ++) {
            int left = findIndex(a, buildings[i][0]);
            int right = findIndex(a, buildings[i][1]);
            setHeight(segmentTree, left, right, 0, buildings[i][2]);
        }

        int[] h = new int[a.size()];
        calcHeight(segmentTree, h, 0, 0);

        int preHeight = 0;
        List<int[]> result = new ArrayList<>(a.size());
        for (int i = 0; i < h.length; i ++) {
            int currentHeight = h[i];
            if ( preHeight != currentHeight) {
                result.add(new int[]{a.get(i), currentHeight});
                preHeight = currentHeight;
            }
        }

        return result;
    }


    public List<Integer> discrete(int[][] buildings) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < buildings.length; i ++) {
            set.add(buildings[i][0]);
            set.add(buildings[i][1]);
        }
        List<Integer> a = new ArrayList<>(set.size());
        int i = 0;
        for (int e : set) {
            a.add(e);
        }
        Collections.sort(a);
        return a;
    }

    private void buildSegmentTree(Node[] segmentTree, int l, int r, int num) {
        Node current = new Node(l, r);
        segmentTree[num] = current;
        if (l + 1 == r) { return;}
        buildSegmentTree(segmentTree, l, current.mid, num * 2 + 1);
        buildSegmentTree(segmentTree, current.mid, r, num * 2 + 2);
    }

    private int findIndex(List<Integer> a, int position) {
        return Collections.binarySearch(a, position);
    }

    private void setHeight(Node[] segmentTree, int l, int r, int num, int height) {
        Node current = segmentTree[num];
        if (current.left == l && current.right == r) {
            current.height = Math.max(height, current.height);
            return;
        }
        if (r <= current.mid) { setHeight(segmentTree, l, r, num * 2 + 1, height); return;}
        if (l >= current.mid) { setHeight(segmentTree, l, r, num * 2 + 2, height); return;}
        setHeight(segmentTree, l, current.mid, num * 2 + 1, height);
        setHeight(segmentTree, current.mid, r, num * 2 + 2, height);
    }

    private void calcHeight(Node[] segmentTree, int[] h, int num, int height) {
        Node current = segmentTree[num];
        if (current.left + 1 == current.right) {
            h[current.left] = Math.max(height, current.height);
        } else {
            current.height = Math.max(height, current.height);
            calcHeight(segmentTree, h, num * 2 + 1, current.height);
            calcHeight(segmentTree, h, num * 2 + 2, current.height);
        }
    }

    class Node{
        int left;
        int right;
        int mid;
        int height;
        Node(int l, int r) {
            left = l;
            right = r;
            mid = (left + right) >> 1;
        }
    }
}
