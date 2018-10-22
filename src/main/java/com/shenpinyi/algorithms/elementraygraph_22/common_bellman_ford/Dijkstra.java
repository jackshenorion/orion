package com.shenpinyi.algorithms.elementraygraph_22.common_bellman_ford;

import com.google.common.primitives.Doubles;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.ShortestPathResult;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WAdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WEdge;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WNode;

import java.util.*;

public class Dijkstra {

    public ShortestPathResult shortestPath(List<WNode> nodes, WNode s) {

        Map<WNode, WNode> parents = new HashMap<>();
        Map<WNode, Double> distances = new HashMap<>();
        Queue<QNode> qNodes = new PriorityQueue<>((o1, o2) -> Doubles.compare(o1.distance, o2.distance));
        Map<WNode, QNode>  nodeToQNode = new HashMap<>();
        for (WNode node : nodes) {
            if (node == s) {
                QNode qNode = new QNode(0.0, node);
                qNodes.offer(qNode);
                nodeToQNode.put(node, qNode);
                distances.put(node, 0.0);
            } else {
                QNode qNode = new QNode(Double.MAX_VALUE, node);
                qNodes.offer(qNode);
                distances.put(node, Double.MAX_VALUE);
                nodeToQNode.put(node, qNode);
            }
        }

        while (qNodes.size() > 0) {
            QNode qNode = qNodes.poll();
            for (WEdge edge : qNode.node.edges) {
                WNode target = edge.target;
                double d = distances.get(qNode.node) + edge.weight;
                if (distances.get(target) > d) {
                    distances.put(target, d);
                    parents.put(target, qNode.node);
                    QNode targetQNode = nodeToQNode.get(target);
                    qNodes.remove(targetQNode);
                    targetQNode.distance = d;
                    qNodes.add(targetQNode);
                }
            }
        }
        return new ShortestPathResult(distances, parents);
    }

    static class QNode {
        double distance;
        WNode node;

        public QNode(double distance, WNode node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        // s0, t1, x2, y3, z4
        WAdjListGraph wAdjListGraph = new WAdjListGraph(5,
                new int[][]{
                        {0, 1},//st3
                        {0, 3},//sy5
                        {1, 2},//tx6
                        {1, 3},//ty2
                        {2, 4},//xz11
                        {4, 2},//zx7
                        {4, 0},//zs3
                        {3, 1},//yt1
                        {3, 2},//yx4
                        {3, 4}//yz6
                },
                new double[]{3, 5, 6, 2, 11, 7, 3, 1, 4, 6},
                true);
        System.out.println(wAdjListGraph);
        ShortestPathResult shortestPathResult = new Dijkstra().shortestPath(wAdjListGraph.nodes, wAdjListGraph.nodes.get(0));
        System.out.println(shortestPathResult);

    }



}
