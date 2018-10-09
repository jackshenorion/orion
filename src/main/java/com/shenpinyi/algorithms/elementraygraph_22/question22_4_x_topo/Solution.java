package com.shenpinyi.algorithms.elementraygraph_22.question22_4_x_topo;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.Node;

import java.util.*;

public class Solution {

    public List<Node> topoSort(List<Node> nodes) {
        List<Node> result = new ArrayList<>();
        HashMap<Node, Integer> colors = new HashMap<>();
        for (Node node : nodes) {
            if (colors.get(node) == null) {
                dfs(node, colors, result);
            }
        }
        Collections.reverse(result);
        return result;
    }

    private void dfs(Node node, Map<Node, Integer> colors, List<Node> result) {
        colors.put(node, 1);
        for (Node neighbor : node.neighbors) {
            if (colors.get(neighbor) == null) {
                dfs(neighbor, colors, result);
            }
        }
        colors.put(node, 2);
        result.add(node);
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
