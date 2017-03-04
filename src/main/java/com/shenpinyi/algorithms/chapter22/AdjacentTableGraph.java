package com.shenpinyi.algorithms.chapter22;

import java.util.List;

public class AdjacentMatrixGraph <V, E> {

    private Object[][] adjacentMatrix;
    private List<Vertex<V>> vertexs;

    public Object[][] getAdjacentMatrix() {
        return adjacentMatrix;
    }

    public void setAdjacentMatrix(Object[][] adjacentMatrix) {
        this.adjacentMatrix = adjacentMatrix;
    }

    public List<Vertex<V>> getVertexs() {
        return vertexs;
    }

    public void setVertexs(List<Vertex<V>> vertexs) {
        this.vertexs = vertexs;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(" \t");
        for (int i = 0; i < vertexs.size(); i ++) {
            builder.append(vertexs.get(i).getValue() + "\t");
        }
        builder.append(" \n");


        for (int i = 0; i < adjacentMatrix.length; i ++) {
            builder.append(vertexs.get(i).getValue() + "\t");
            for (int j = 0; j < adjacentMatrix[i].length; j ++) {
                builder.append((E) adjacentMatrix[i][j] == null ? "0\t" : adjacentMatrix[i][j] + "\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
