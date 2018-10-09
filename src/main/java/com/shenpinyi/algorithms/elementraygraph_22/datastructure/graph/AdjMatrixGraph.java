package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.Arrays;

public class AdjMatrixGraph {

    public int[][] adjMatrix;

    public AdjMatrixGraph(int n) {
        adjMatrix = new int[n][n];
    }

    public AdjMatrixGraph(int n, int[][] edges) {
        adjMatrix = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            adjMatrix[from][to] = 1;
        }
    }

    public AdjMatrixGraph(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdjMatrixGraph {\n");
        for (int i = 0; i < adjMatrix.length; i++) {
            sb.append(i);
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] != 0) {
                    sb.append(" -> ");
                    sb.append(j);
                }
            }
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
