package com.shenpinyi.algorithms.chapter22;

/**
 * Created by sj on 2017/3/5.
 */
public class BFS {
    private int[] distances;
    private int[] parents;

    public BFS(int[] d, int[] pi) {
        this.distances = d;
        this.parents = pi;
    }

    public int[] getDistances() {
        return distances;
    }

    public int[] getParents() {
        return parents;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Distances: ");
        for (int i = 0; i < distances.length; i ++) {
            builder.append(distances[i] + " ");
        }

        builder.append("\nParents: ");
        for (int i = 0; i < parents.length; i ++) {
            builder.append(parents[i] + " ");
        }
        return builder.toString();
    }
}
