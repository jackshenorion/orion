package com.shenpinyi.algorithms.elementraygraph_22.question22_1_4;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.Node;

import java.util.*;

public class Solution {

    public List<Node> toUndirected(List<Node> nodes) {
        Map<Node, Node> originToNewNodes = new HashMap<>();
        Map<Node, Set<Node>> newNodeToNeighbors = new HashMap<>();
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            Node newNode = new Node(node.val);
            result.add(newNode);
            originToNewNodes.putIfAbsent(node, newNode);
            newNodeToNeighbors.putIfAbsent(newNode, new HashSet<>());
        }
        for (Node node : nodes) {
            for (Node neighbor : node.neighbors) {
                if (node == neighbor) {
                    continue;
                }
                newNodeToNeighbors.get(originToNewNodes.get(node))
                        .add(originToNewNodes.get(neighbor));
            }
        }
        for (Node newNode : newNodeToNeighbors.keySet()) {
            for (Node neighbor : newNodeToNeighbors.get(newNode)) {
                newNode.neighbors.add(neighbor);
                neighbor.neighbors.add(newNode);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1},
                {0, 4},
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 3},
                {3, 4}
        };
        AdjListGraph adjListGraph = new AdjListGraph(5, edges);
        System.out.println(adjListGraph);
        List<Node> newNodes = new Solution().toUndirected(adjListGraph.nodes);
        AdjListGraph newGraph = new AdjListGraph(newNodes);
        System.out.println(newGraph);
    }

}
