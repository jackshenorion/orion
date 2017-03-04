package com.shenpinyi.algorithms.chapter22;

import java.util.List;

public class AdjacentTableGraph<V, E> {

    private List<List<AdjacentTableGraphNode<E>>> adjacentTable;
    private List<Vertex<V>> vertexs;

    public List<List<AdjacentTableGraphNode<E>>> getAdjacentTable() {
        return adjacentTable;
    }

    public void setAdjacentTable(List<List<AdjacentTableGraphNode<E>>> adjacentTable) {
        this.adjacentTable = adjacentTable;
    }

    public List<Vertex<V>> getVertexs() {
        return vertexs;
    }

    public void setVertexs(List<Vertex<V>> vertexs) {
        this.vertexs = vertexs;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < adjacentTable.size(); i ++) {
            builder.append(vertexs.get(i).getValue() + ":\t");
            for (int j = 0; j < adjacentTable.get(i).size(); j++) {
                builder.append(vertexs.get(adjacentTable.get(i).get(j).getVertexIndex()).getValue() + "\t");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
