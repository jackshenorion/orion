package com.shenpinyi.algorithms.elementraygraph_22.common_detect_loop;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public boolean hasLoop(List<Node> nodes) {
        Map<Node, Integer> nodeColors = new HashMap<>();
        for (Node node : nodes) {
            if (nodeColors.get(node) == null) {
                if (hasLoopHelper(node, nodeColors)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasLoopHelper(Node node, Map<Node, Integer> nodeColors) {
        nodeColors.putIfAbsent(node, 1); //visiting
        for (Node neighbor : node.neighbors) {
            if (nodeColors.get(neighbor) == null) {
                if (hasLoopHelper(neighbor, nodeColors)) {
                    return true;
                }
            } else if (nodeColors.get(neighbor) == 1) {
                return true;
            }
        }
        nodeColors.put(node, 2);
        return false;
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
        boolean hasLoop = new Solution().hasLoop(adjListGraph.nodes);
        System.out.println(hasLoop);

        int[][] edgesWithLoop = new int[][]{
                {0, 1},
                {1, 3},
                {2, 3},
                {3, 1},
                {3, 4}
        };
        AdjListGraph adjListGraphWithLoop = new AdjListGraph(5, edgesWithLoop);
        System.out.println(adjListGraphWithLoop);
        boolean hasLoop2 = new Solution().hasLoop(adjListGraphWithLoop.nodes);
        System.out.println(hasLoop2);
    }
}
