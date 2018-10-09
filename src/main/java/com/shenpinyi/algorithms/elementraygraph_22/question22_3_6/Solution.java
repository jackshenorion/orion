package com.shenpinyi.algorithms.elementraygraph_22.question22_3_6;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjMatrixGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.DfsResult;

public class Solution {

    private int[][] graph;
    private int[] colors;
    private int[] discoveryTimes;
    private int[] finishTimes;
    private int[] parents;
    private int time = 0;

    public DfsResult dfs(int[][] g) {
        graph = g;
        colors = new int[graph.length];
        discoveryTimes = new int[graph.length];
        finishTimes = new int[graph.length];
        parents = new int[graph.length];
        time = 0;
        for (int i = 0; i < graph.length; i++) {
            parents[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                dfs(i);
            }
        }
        return new DfsResult(discoveryTimes, finishTimes, parents);
    }

    private void dfs(int current) {
        colors[current] = 1;
        discoveryTimes[current] = time++;
        for (int i = 0; i < graph.length; i++) {
            if (graph[current][i] != 0 && colors[i] == 0) {
                parents[i] = current;
                dfs(i);
            }
        }
        finishTimes[current] = time++;
        colors[current] = 2;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1},
                {1, 3},
                {2, 3},
                {3, 4}
        };
        AdjMatrixGraph adjMatrixGraphd = new AdjMatrixGraph(5, edges);
        System.out.println(adjMatrixGraphd);
        DfsResult dfsResult = new Solution().dfs(adjMatrixGraphd.adjMatrix);
        System.out.println(dfsResult);
    }

}
