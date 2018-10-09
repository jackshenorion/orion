package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors = new ArrayList<>();

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
