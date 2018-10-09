package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.Arrays;

public class BfsResultMatrix {
    private int[] distances;
    private int[] parents;

    public BfsResultMatrix(int[] d, int[] pi) {
        this.distances = d;
        this.parents = pi;
    }

    public int[] getDistances() {
        return distances;
    }

    public int[] getParents() {
        return parents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parents.length; i++) {
            int current = i;
            sb.append("\n");
            sb.append(current + "(" + distances[current] + ")");
            while (parents[current] != -1) {
                current = parents[current];
                sb.append(" <- " + current + "(" + distances[current] + ")");
            }
        }
        return "BfsResultMatrix{" + sb.toString() + "}";
    }
}