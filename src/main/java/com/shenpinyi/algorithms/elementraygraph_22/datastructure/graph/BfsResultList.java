package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.Map;

public class BfsResultList {
    private Map<Node, Integer> distances;
    private Map<Node, Node> parents;

    public BfsResultList(Map<Node, Integer> d, Map<Node, Node> p) {
        this.distances = d;
        this.parents = p;
    }

    public Map<Node, Integer> getDistances() {
        return distances;
    }

    public Map<Node, Node> getParents() {
        return parents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : parents.keySet()) {
            sb.append("\n");
            Node current = node;
            sb.append(node.val + "(" + distances.get(current) + ")");
            while (parents.get(current) != null) {
                current = parents.get(current);
                sb.append(" <- " + current.val + "(" + distances.get(current) + ")");
            }
        }
        return "BfsResultList{" + sb.toString() + '}';
    }
}