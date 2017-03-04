package com.shenpinyi.algorithms.chapter22;

import java.util.List;

<<<<<<< HEAD
public class AdjacentTableGraph<V, E> {

    private List<List<AdjacentTableGraphNode<E>>> adjacentTable;
    private List<Vertex<V>> vertexs;

    public List<List<AdjacentTableGraphNode<E>>> getAdjacentTable() {
        return adjacentTable;
    }

    public void setAdjacentTable(List<List<AdjacentTableGraphNode<E>>> adjacentTable) {
        this.adjacentTable = adjacentTable;
=======
public class AdjacentMatrixGraph <V, E> {

    private Object[][] adjacentMatrix;
    private List<Vertex<V>> vertexs;

    public Object[][] getAdjacentMatrix() {
        return adjacentMatrix;
    }

    public void setAdjacentMatrix(Object[][] adjacentMatrix) {
        this.adjacentMatrix = adjacentMatrix;
>>>>>>> dc3a43cecaa516033d9a02e119e17d1c2334b919
    }

    public List<Vertex<V>> getVertexs() {
        return vertexs;
    }

    public void setVertexs(List<Vertex<V>> vertexs) {
        this.vertexs = vertexs;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

<<<<<<< HEAD
        for (int i = 0; i < adjacentTable.size(); i ++) {
            builder.append(vertexs.get(i).getValue() + ":\t");
            for (int j = 0; j < adjacentTable.get(i).size(); j++) {
                builder.append(vertexs.get(adjacentTable.get(i).get(j).getVertexIndex()).getValue() + "\t");
            }
            builder.append("\n");
        }

=======
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
>>>>>>> dc3a43cecaa516033d9a02e119e17d1c2334b919
        return builder.toString();
    }
}
