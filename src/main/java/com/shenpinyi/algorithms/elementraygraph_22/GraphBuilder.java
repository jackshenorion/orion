package com.shenpinyi.algorithms.elementraygraph_22;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder <V, E> {
    private List<Vertex<V>> vertexs;
    private List<Edge<E>> edges;

    public GraphBuilder setVertexs(List<Vertex<V>> vertexs) {
        this.vertexs = vertexs;
        return this;
    }

    public GraphBuilder setEdges(List<Edge<E>> edges) {
        this.edges = edges;
        return this;
    }

    public AdjacentMatrixGraph<V, E> buildAdjacentMatrixGraph() {
        AdjacentMatrixGraph<V, E> graph = new AdjacentMatrixGraph<>();
        Object[][] edgesMatrix = new Object[vertexs.size()][vertexs.size()];
        for(Edge e : edges) {
            edgesMatrix[e.getSource()][e.getTarget()] = e.getCost();
            if (!e.isHasDirection()) {
                edgesMatrix[e.getTarget()][e.getSource()] = e.getCost();
            }
        }
        graph.setVertexs(vertexs);
        graph.setAdjacentMatrix(edgesMatrix);
        return graph;
    }

    public AdjacentTableGraph<V, E> buildAdjacentTableGraph() {
        AdjacentTableGraph<V, E> graph = new AdjacentTableGraph<>();

        List<List<AdjacentTableGraphNode<E>>> table = new ArrayList<>();
        for (int i = 0; i < vertexs.size(); i++) {
            table.add(new ArrayList<>());
        }

        for(Edge e : edges) {
            table.get(e.getSource()).add(new AdjacentTableGraphNode().setVertexIndex(e.getTarget()).setCost(e.getCost()));
            if (!e.isHasDirection()) {
                table.get(e.getTarget()).add(new AdjacentTableGraphNode().setVertexIndex(e.getSource()).setCost(e.getCost()));
            }
        }
        graph.setVertexs(vertexs);
        graph.setAdjacentTable(table);
        return graph;
    }
}
