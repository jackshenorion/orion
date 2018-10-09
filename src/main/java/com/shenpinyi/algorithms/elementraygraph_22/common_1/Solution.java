package com.shenpinyi.algorithms.elementraygraph_22.common_1;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.AdjMatrixGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.Node;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1},
                {0, 4},
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 3},
                {3, 4}
        };
        AdjListGraph adjListGraph = new AdjListGraph(5, edges);
        System.out.println(adjListGraph);

        AdjMatrixGraph adjMatrixGraph = new AdjMatrixGraph(5, edges);
        System.out.println(adjMatrixGraph);

        int[][] transposeMatrix = new com.shenpinyi.algorithms.elementraygraph_22.question22_1_3.Solution().transpose(adjMatrixGraph.adjMatrix);
        System.out.println(new AdjMatrixGraph(transposeMatrix));

        List<Node> transposeList = new com.shenpinyi.algorithms.elementraygraph_22.question22_1_3.Solution().transpose(adjListGraph.nodes);
        System.out.println(new AdjListGraph(transposeList));
    }
}
