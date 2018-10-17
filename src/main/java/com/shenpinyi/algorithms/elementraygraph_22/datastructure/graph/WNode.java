package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class WNode {

    public int val;
    public List<WEdge> edges = new ArrayList<>();

    public WNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "WNode{" +
                "val=" + val +
                ", edges=" + edges +
                '}';
    }
}
