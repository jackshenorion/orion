package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.Map;

public class ShortestPathResult {
    private Map<WNode, Double> distances;
    private Map<WNode, WNode> parents;

    public ShortestPathResult(Map<WNode, Double> d, Map<WNode, WNode> p) {
        this.distances = d;
        this.parents = p;
    }

    public Map<WNode, Double> getDistances() {
        return distances;
    }

    public Map<WNode, WNode> getParents() {
        return parents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (WNode node : parents.keySet()) {
            sb.append("\n");
            WNode current = node;
            sb.append(node.val + "(" + distances.get(current) + ")");
            while (parents.get(current) != null) {
                current = parents.get(current);
                sb.append(" <- " + current.val + "(" + distances.get(current) + ")");
            }
        }
        return "ShortestPathResult{" + sb.toString() + '}';
    }
}