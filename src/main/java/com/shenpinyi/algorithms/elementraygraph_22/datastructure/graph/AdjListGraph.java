package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph {

    public List<Node> nodes = new ArrayList<>();

    public AdjListGraph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            Node fromNode = nodes.get(from);
            Node toNode = nodes.get(to);
            fromNode.neighbors.add(toNode);
        }
    }

    public AdjListGraph(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdjListGraph {\n");
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            sb.append(node.val);
            for (Node adj : node.neighbors) {
                sb.append(" -> ");
                sb.append(adj.val);
            }
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

}
