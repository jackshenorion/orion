package com.shenpinyi.algorithms.elementraygraph_22.question22_1_1;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.Node;

import java.util.HashMap;
import java.util.Map;


public class Solution {

    public int[] getOutDegrees(Node[] nodes) {
        int[] outDegrees = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            outDegrees[i] = node.neighbors.size();
        }
        return outDegrees;
    }


    public int[] getInDegrees(Node[] nodes) {
        int[] inDegrees = new int[nodes.length];
        Map<Node, Integer> stat = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            for (Node neighbor : node.neighbors) {
                stat.putIfAbsent(neighbor, 0);
                stat.put(neighbor, stat.get(neighbor) + 1);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            inDegrees[i] = stat.getOrDefault(nodes[i], 0);
        }
        return inDegrees;
    }

    public int[] getOutDegrees(int[][] adjMatrix) {
        int[] outDegrees = new int[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] != 0) {
                    outDegrees[i]++;
                }
            }
        }
        return outDegrees;
    }

    public int[] getInDegrees(int[][] adjMatrix) {
        int[] inDegrees = new int[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] != 0) {
                    inDegrees[j]++;
                }
            }
        }
        return inDegrees;
    }

}
