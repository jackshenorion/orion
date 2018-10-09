package com.shenpinyi.algorithms.elementraygraph_22.question22_1_3;


import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int[][] transpose(int[][] graph) {
        int[][] result = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                result[j][i] = graph[i][j];
            }
        }
        return result;
    }

    public List<Node> transpose(List<Node> graph) {
        List<Node> result = new ArrayList<>();
        HashMap<Node, Node> originToNewNode = new HashMap<>();
        for (Node node : graph) {
            Node newNode = new Node(node.val);
            result.add(newNode);
            originToNewNode.put(node, newNode);
        }
        for (Node node : graph) {
            Node newNode = originToNewNode.get(node);
            for (Node neighbor : node.neighbors) {
                originToNewNode.get(neighbor).neighbors.add(newNode);
            }
        }
        return result;
    }

}
