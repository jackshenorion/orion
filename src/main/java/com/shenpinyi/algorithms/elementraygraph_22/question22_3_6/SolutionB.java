package com.shenpinyi.algorithms.elementraygraph_22.question22_3_6;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjMatrixGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.DfsResult;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionB {

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
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i);
                colors[i] = 1;
                discoveryTimes[i] = time++;
                while (!stack.isEmpty()) {
                    Integer current = stack.peek();
                    if (colors[current] == 2) {
                        stack.pop();
                        finishTimes[current] = time++;
                        continue;
                    }
                    for (int j = 0; j < graph.length; j++) {
                        if (graph[current][j] != 0 && colors[j] == 0) {
                            parents[j] = current;
                            colors[j] = 1;
                            discoveryTimes[j] = time++;
                            stack.push(j);
                        }
                    }
                    colors[current] = 2;
                }
            }
        }
        return new DfsResult(discoveryTimes, finishTimes, parents);
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
        DfsResult dfsResult = new SolutionB().dfs(adjMatrixGraphd.adjMatrix);
        System.out.println(dfsResult);
    }

}
