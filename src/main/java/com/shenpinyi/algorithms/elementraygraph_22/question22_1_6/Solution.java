package com.shenpinyi.algorithms.elementraygraph_22.question22_1_6;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjMatrixGraph;

public class Solution {

    public int findUniversalSink(int[][] graph) {
        int current = 0;
        for (int i = 1; i < graph.length; i++) {
            if (graph[current][i] != 0) { // current is not sink
                current = i;
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (current == i) {
                continue;
            }
            if (graph[current][i] != 0 || graph[i][current] == 0) {
                return -1;
            }
        }
        return current;
    }


    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0, 1, 1},
                {0, 0, 0},
                {1, 1, 1}
        };
        AdjMatrixGraph adjMatrixGraph = new AdjMatrixGraph(graph);
        System.out.println(adjMatrixGraph);
        System.out.println(new Solution().findUniversalSink(graph));

        int[][] graphB = new int[][] {
                {0, 0, 1},
                {0, 0, 0},
                {1, 1, 1}
        };
        AdjMatrixGraph adjMatrixGraphB = new AdjMatrixGraph(graphB);
        System.out.println(adjMatrixGraphB);
        System.out.println(new Solution().findUniversalSink(graphB));
    }
}
