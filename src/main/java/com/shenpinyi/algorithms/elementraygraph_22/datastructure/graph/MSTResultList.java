package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.Comparator;
import java.util.Map;

public class MSTResultList {

    public Map<WNode, WNode> parents;
    public Map<WNode, Double> weights;

    public MSTResultList(Map<WNode, WNode> parents, Map<WNode, Double> weights) {
        this.parents = parents;
        this.weights = weights;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        weights.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach(entry -> {
                    WNode node = entry.getKey();
                    WNode parent = parents.get(node);
                    sb.append(parent.val + " <-> " + node.val + " w(" + weights.get(node) + ")");
                    sb.append("\n");
                });
        return sb.toString();
    }
}
