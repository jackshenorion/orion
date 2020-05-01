package com.shenpinyi.algorithms.disjointset.common_disjointset;

public class DisjointSetArray {

    private int[] parents;
    private int[] ranks;
    private int count;

    public void makeSet(int n) {
        parents = new int[n];
        ranks = new int[n];
        count = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }
    }

    public int findSet(int v) {
        if (parents[v] != v) {
            parents[v] = findSet(parents[v]);
        }
        return parents[v];
    }

    public void addLink(int a, int b) {
        if (findSet(a) != findSet(b)) {
            union(a, b);
        }
    }

    private void union(int a, int b) {
        int sa = findSet(a);
        int sb = findSet(b);
        if (sa == sb) {
            return;
        }
        if (ranks[sa] > ranks[sb]) {
            parents[sb] = sa;
        } else if(ranks[sa] == ranks[sb]) {
            parents[sb] = sa;
            ranks[sa]++;
        } else {
            parents[sa] = sb;
        }
        count--;
    }

    public int getCountOfSet() {
        return count;
    }

    public boolean sameSet(int a, int b) {
        return findSet(a) == findSet(b);
    }

    public static void main(String[] args) {
        // a0 b1 c2 d3 e4 f5 g6 h7 i8 j9
        DisjointSetArray disjointSet = new DisjointSetArray();
        disjointSet.makeSet(10);
        disjointSet.addLink(0, 1);
        disjointSet.addLink(0, 2);
        disjointSet.addLink(1, 2);
        disjointSet.addLink(1, 3);
        disjointSet.addLink(4, 5);
        disjointSet.addLink(4, 6);
        disjointSet.addLink(7, 9);
        System.out.println(disjointSet.getCountOfSet());
        System.out.println(disjointSet.sameSet(0,3));
        System.out.println(disjointSet.sameSet(0,7));
    }
}
