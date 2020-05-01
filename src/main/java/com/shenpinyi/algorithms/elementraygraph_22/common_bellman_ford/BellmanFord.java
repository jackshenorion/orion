package com.shenpinyi.algorithms.elementraygraph_22.common_bellman_ford;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.ShortestPathResult;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WAdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WEdge;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    public ShortestPathResult shortestPath(List<WNode> nodes, WNode s) {
        Map<WNode, Double> distances = new HashMap<>();
        Map<WNode, WNode> parents = new HashMap<>();
        for (WNode node : nodes) {
            distances.putIfAbsent(node, Double.MAX_VALUE);
        }
        distances.put(s, 0.0);
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (WNode node : nodes) {
                for (WEdge edge : node.edges) {
                    WNode target = edge.target;
                    if (distances.get(target) > (distances.get(node) + edge.weight)) {
                        parents.put(target, node);
                        distances.put(target, distances.get(node) + edge.weight);
                    }
                }
            }
        }
        for (WNode node : nodes) {
            for (WEdge edge : node.edges) {
                WNode target = edge.target;
                if (distances.get(target) > (distances.get(node) + edge.weight)) {
                    return null;
                }
            }
        }
        return new ShortestPathResult(distances, parents);
    }

    public static void main(String[] args) {
        // s0, t1, x2, y3, z4
        WAdjListGraph wAdjListGraph = new WAdjListGraph(5,
                new int[][]{
                        {0, 1},//st3
                        {0, 3},//sy5
                        {1, 2},//tx6
                        {1, 3},//ty2
                        {2, 4},//xz11
                        {4, 2},//zx7
                        {4, 0},//zs3
                        {3, 1},//yt1
                        {3, 2},//yx4
                        {3, 4}//yz6
                },
                new double[]{3, 5, 6, 2, 11, 7, 3, 1, 4, 6},
                true);
        System.out.println(wAdjListGraph);
        ShortestPathResult shortestPathResult = new BellmanFord().shortestPath(wAdjListGraph.nodes, wAdjListGraph.nodes.get(0));
        System.out.println(shortestPathResult);

    }


}
