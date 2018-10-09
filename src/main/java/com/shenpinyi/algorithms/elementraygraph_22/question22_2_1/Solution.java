package com.shenpinyi.algorithms.elementraygraph_22.question22_2_1;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.*;

import java.util.*;

public class Solution {

    public BfsResultList bfs(Node node) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> parents = new HashMap<>();

        queue.offer(node);
        visited.add(node);
        distances.putIfAbsent(node, 0);

        while (queue.size() > 0) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                parents.put(neighbor, current);
                distances.put(neighbor, distances.get(current));
                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
        return new BfsResultList(distances, parents);
    }

    public BfsResultMatrix bfs(int[][] graph, int from) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distances = new int[graph.length];
        int[] parents = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distances[i] = Integer.MAX_VALUE;
            parents[i] = -1;
        }
        queue.offer(from);
        visited[from] = true;
        distances[from] = 0;
        parents[from] = -1;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (current == i) {
                    continue;
                }
                if (graph[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    parents[i] = current;
                    distances[i] = distances[current] + 1;
                    queue.offer(i);
                }
            }
        }
        return new BfsResultMatrix(distances, parents);
    }


    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1},
                {0, 4},
                {1, 2},
                {1, 3},
                {2, 3},
                {3, 4}
        };
        AdjListGraph adjListGraph = new AdjListGraph(5, edges);
        System.out.println(adjListGraph);
        BfsResultList bfsResultList = new Solution().bfs(adjListGraph.nodes.get(1));
        System.out.println(bfsResultList);

        AdjMatrixGraph adjMatrixGraphd = new AdjMatrixGraph(5, edges);
        System.out.println(adjMatrixGraphd);
        BfsResultMatrix bfsResultMatrix = new Solution().bfs(adjMatrixGraphd.adjMatrix, 1);
        System.out.println(bfsResultMatrix);
    }
}
