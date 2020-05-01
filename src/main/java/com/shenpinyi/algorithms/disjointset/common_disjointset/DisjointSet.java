package com.shenpinyi.algorithms.disjointset.common_disjointset;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    Map<Integer, Integer> parents = new HashMap<>();
    Map<Integer, Integer> ranks = new HashMap<>();

    public void addSet(int s) { // instead of MakeSet, we can add nodes one by one now
        if (parents.containsKey(s)) {
            return;
        }
        parents.put(s, s);
        ranks.put(s, 0);
    }

    public void addLink(int u, int v) {
        if (findSet(u) != findSet(v)) {
            union(u, v);
        }
    }

    public int findSet(int u) {
        if (parents.get(u) != u) {
            parents.put(u, findSet(parents.get(u)));
        }
        return parents.get(u);
    }

    public void union(int u, int v) {
        int set1 = findSet(u);
        int set2 = findSet(v);
        Integer rank1 = ranks.get(set1);
        Integer rank2 = ranks.get(set2);
        if (rank1 == rank2) {
            parents.put(set1, set2);
            ranks.put(set2, ranks.get(set2) + 1);
        } else if (rank1 > rank2) {
            parents.put(set2, set1);
        } else {
            parents.put(set1, set2);
        }
    }

    public boolean sameSet(int u, int v) {
        return findSet(u) == findSet(v);
    }


    public static void main(String[] args) {
        // a0 b1 c2 d3 e4 f5 g6 h7 i8 j9
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.addSet(0);
        disjointSet.addSet(1);
        disjointSet.addSet(2);
        disjointSet.addSet(3);
        disjointSet.addSet(4);
        disjointSet.addSet(5);
        disjointSet.addLink(0, 1);
        disjointSet.addLink(0, 2);
        disjointSet.addLink(1, 2);
        disjointSet.addLink(1, 3);
        disjointSet.addLink(4, 5);
        disjointSet.addSet(6);
        disjointSet.addLink(4, 6);
        disjointSet.addSet(7);
        disjointSet.addSet(8);
        disjointSet.addSet(9);
        disjointSet.addLink(7, 9);
        System.out.println(disjointSet.sameSet(0, 3));
        System.out.println(disjointSet.sameSet(0, 7));
        System.out.println(disjointSet.parents);
        System.out.println(disjointSet.ranks);

    }

}
