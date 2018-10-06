package com.shenpinyi.algorithms.elementraygraph_22.excersice2216;

import com.shenpinyi.algorithms.elementraygraph_22.AdjacentMatrixGraph;
import com.shenpinyi.algorithms.elementraygraph_22.Vertex;

import java.util.List;

/**
 * Created by sj on 2017/3/5.
 */
public class UniversalSinkFinder {

    private AdjacentMatrixGraph<String, Integer> graph;
    private Object[][] matrix;
    private List<Vertex<String>> vertexes;

    public UniversalSinkFinder(AdjacentMatrixGraph<String, Integer> graph) {
        this.graph = graph;
        this.matrix = graph.getAdjacentMatrix();
        this.vertexes = graph.getVertexs();
    }

    public UniversalSinkFinder setGraph(AdjacentMatrixGraph<String, Integer> graph) {
        this.graph = graph;
        return this;
    }

    public String find() {
        if (this.graph == null) {
            return "Graph is empty!";
        } else {
            System.out.println("Input matrix:\n" + graph.toString());
        }


        int checkVertex = findCheckVertex();
        if (checkVertex == -1) {
            return "Universal sink is not found!";
        } else {
            return checkCross(checkVertex) ? "Universal sink: " + vertexes.get(checkVertex).getValue() : "Universal sink is not found!";
        }
    }

    private int findCheckVertex() {
        int vCount = vertexes.size();

        Outer: for (int i = 0; i < vCount; i ++) {
            if (isConnected(i, i)) {
                continue;
            } else {
                int j;
                for (j = i + 1; j < vCount; j ++) {
                    if (!isConnected(i, j)) {
                        continue;
                    } else {
                        i = j;
                        continue Outer;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    private boolean checkCross(int vertexIdx) {
        if (isConnected(vertexIdx, vertexIdx)) {
            return false;
        }

        for (int i = 0; i < graph.getVertexs().size(); i++) {
            if (i != vertexIdx && (!isConnected(i, vertexIdx) || isConnected(vertexIdx, i))) {
                 return false;
            }
        }
        return true;
    }

    private boolean isConnected(int fromVertex, int toVertex) {
        return matrix[fromVertex][toVertex] != null && (int) matrix[fromVertex][toVertex] != 0;
    }


}
