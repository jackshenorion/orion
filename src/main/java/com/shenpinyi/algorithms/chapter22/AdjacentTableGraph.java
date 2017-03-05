package com.shenpinyi.algorithms.chapter22;

import java.util.Arrays;
import java.util.LinkedList;
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

    public BFS getBFS(int s) {
        int vCount = vertexs.size();

        Color[] colors = new Color[vCount];
        int[] distances = new int[vCount];
        int[] parents = new int[vCount];
        LinkedList<Integer> queue = new LinkedList();

        Arrays.fill(colors, Color.White);
        Arrays.fill(distances, -1);
        Arrays.fill(parents, -1);

        queue.push(s);
        colors[s] = Color.Grey;
        distances[s] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<AdjacentTableGraphNode<E>> adjs= adjacentTable.get(current);
            for (AdjacentTableGraphNode adj : adjs) {
                int v = adj.getVertexIndex();
                if (colors[v] == Color.Grey ||
                        colors[v] == Color.Black) {
                    continue;
                } else {
                    colors[v] = Color.Grey;
                    distances[v] = distances[current] + 1;
                    parents[v] = current;
                    queue.push(v);
                }
            }
        }

        return new BFS(distances, parents);
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
