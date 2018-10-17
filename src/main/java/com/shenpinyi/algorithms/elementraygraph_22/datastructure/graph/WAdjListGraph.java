package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class WAdjListGraph {

    public List<WNode> nodes = new ArrayList<>();

    public WAdjListGraph(int n, int[][] edges, double[] weights, boolean directed) {
        for (int i = 0; i < n; i++) {
            nodes.add(new WNode(i));
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = weights[i];
            WNode fromNode = nodes.get(from);
            WNode toNode = nodes.get(to);
            WEdge edge = new WEdge(fromNode, toNode, weight);
            fromNode.edges.add(edge);
            if (!directed) {
                WEdge reverseEdge = new WEdge(toNode, fromNode, weight);
                toNode.edges.add(reverseEdge);
            }
        }
    }

    public WAdjListGraph(List<WNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WAdjListGraph {\n");
        for (int i = 0; i < nodes.size(); i++) {
            WNode node = nodes.get(i);
            sb.append(node.val);
            for (WEdge edge : node.edges) {
                sb.append(" -> ");
                sb.append(edge.target.val);
                sb.append("(" + edge.weight + ")");
            }
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

}
