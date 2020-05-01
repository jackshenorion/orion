package com.shenpinyi.algorithms.elementraygraph_22.common_bellman_ford;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.ShortestPathResult;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WAdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WEdge;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WNode;

import java.util.*;

public class DAGShortestPath {

    public ShortestPathResult shortestPath(List<WNode> nodes, WNode source) {
        List<WNode> topoNodes = topoOrder(source);
        Map<WNode, Double> distances = new HashMap<>();
        Map<WNode, WNode> parents = new HashMap<>();
        distances.put(source, 0.0);
        for (WNode node : topoNodes) {
            for (WEdge edge : node.edges) {
                WNode target = edge.target;
                if (distances.getOrDefault(target, Double.MAX_VALUE) > distances.get(node) + edge.weight) {
                    distances.put(target, distances.get(node) + edge.weight);
                    parents.put(target, node);
                }
            }
        }
        return new ShortestPathResult(distances, parents);
    }

    private List<WNode> topoOrder(WNode node) {
        List<WNode> result = new ArrayList<>();
        HashMap<WNode, Integer> visited = new HashMap<>(); // 1: visiting, 2
        dfs(node, visited, result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(WNode node, Map<WNode, Integer> visited, List<WNode> result) {
        visited.put(node, 1);
        for (WEdge edge : node.edges) {
            if (visited.get(edge.target) == null) {
                dfs(edge.target, visited, result);
            } else if (visited.get(edge.target) == 1) { // visiting
                throw new IllegalArgumentException("Input graph has cycle!");
            } else if (visited.get(edge.target) == 2) { // visited
                continue;
            }
        }
        visited.put(node, 2);
        result.add(node);
    }


    public static void main(String[] args) {
        // r0, s1, t2, x3, y4, z5
        WAdjListGraph wAdjListGraph = new WAdjListGraph(6,
                new int[][]{
                        {0, 1},//rs5
                        {0, 2},//rt3
                        {1, 2},//st2
                        {1, 3},//sx6
                        {2, 3},//tx7
                        {2, 4},//ty4
                        {2, 5},//tz2
                        {3, 4},//xy-1
                        {3, 5},//xz1
                        {4, 5}//yz-2
                },
                new double[]{5, 3, 2, 6, 7, 4, 2, -1, 1, -2},
                true);
        System.out.println(wAdjListGraph);
        ShortestPathResult shortestPathResult = new DAGShortestPath().shortestPath(wAdjListGraph.nodes, wAdjListGraph.nodes.get(1));
        System.out.println(shortestPathResult);
    }


}
