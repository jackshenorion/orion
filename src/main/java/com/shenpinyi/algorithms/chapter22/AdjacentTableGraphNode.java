package com.shenpinyi.algorithms.chapter22;

/**
 * Created by sj on 2017/3/4.
 */
public class AdjacentTableGraphNode<E> {
    private int vertexIndex;
    private E cost;

    public int getVertexIndex() {
        return vertexIndex;
    }

    public AdjacentTableGraphNode setVertexIndex(int vertexIndex) {
        this.vertexIndex = vertexIndex;
        return this;
    }

    public E getCost() {
        return cost;
    }

    public AdjacentTableGraphNode setCost(E cost) {
        this.cost = cost;
        return this;
    }
}
