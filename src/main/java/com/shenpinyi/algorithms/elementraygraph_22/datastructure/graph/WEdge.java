package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

public class WEdge {
    public WNode source;
    public WNode target;
    public double weight;

    public WEdge(WNode source, WNode target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WEdge{" +
                "source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                '}';
    }
}
