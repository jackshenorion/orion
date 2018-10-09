package com.shenpinyi.algorithms.elementraygraph_22.question22_4_5;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.Node;

import java.util.*;

public class Solution {

    public List<Node> topoSort(List<Node> nodes) {
        Map<Node, Integer> inDegrees = new HashMap<>();
        for (Node node : nodes) {
            inDegrees.putIfAbsent(node, 0);
        }
        for (Node node : nodes) {
            for (Node neighbor : node.neighbors) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) + 1);
            }
        }
        Queue<Node> queue = new ArrayDeque<>();
        for (Node node : nodes) {
            if (inDegrees.get(node) == 0) {
                queue.offer(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current);
            for (Node neighbor : current.neighbors) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);
                if (inDegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1},
                {1, 3},
                {2, 3},
                {3, 4}
        };
        AdjListGraph adjListGraph = new AdjListGraph(5, edges);
        System.out.println(adjListGraph);
        List<Node> topoSort = new Solution().topoSort(adjListGraph.nodes);
        System.out.println(topoSort);

        int[][] edgesWithLoop = new int[][]{
                {0, 1},
                {1, 3},
                {2, 3},
                {3, 1},
                {3, 4}
        };
        AdjListGraph adjListGraphWithLoop = new AdjListGraph(5, edgesWithLoop);
        System.out.println(adjListGraphWithLoop);
        List<Node> topoSortB = new Solution().topoSort(adjListGraphWithLoop.nodes);
        System.out.println(topoSortB);
    }

}
