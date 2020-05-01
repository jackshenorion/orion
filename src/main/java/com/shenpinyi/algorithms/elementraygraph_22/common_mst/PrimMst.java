package com.shenpinyi.algorithms.elementraygraph_22.common_mst;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.MSTResultList;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WAdjListGraph;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WEdge;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WNode;

import java.util.*;

public class PrimMst {

    public MSTResultList mst(List<WNode> nodes) {
        Set<WNode> onTree = new HashSet<>(); // white nodes which are already on tree
        PriorityQueue<QNode> queue = new PriorityQueue<>();
        Map<WNode, QNode> nodeToQNode = new HashMap<>();
        Map<WNode, Double> weights = new HashMap<>();
        for (WNode node : nodes) {
            QNode qNode = new QNode(node, Double.MAX_VALUE);
            queue.add(qNode);
            nodeToQNode.put(node, qNode);
        }
        Map<WNode, WNode> parents = new HashMap<>();
        while (onTree.size() < nodes.size()) {
            QNode qNode = queue.poll();
            onTree.add(qNode.node);
            for (WEdge edge : qNode.node.edges) {
                WNode target = edge.target;
                double weight = edge.weight;
                if (onTree.contains(target)) { // already on tree
                    continue;
                }
                QNode targetQNode = nodeToQNode.get(target);
                if (targetQNode.weight <= weight) { // if the QNode weight is smaller, then don't change it
                    continue;
                } else { // the the new weight is smaller, then change the weight of QNode
                    queue.remove(targetQNode);
                    targetQNode.weight = weight;
                    queue.add(targetQNode);
                    parents.put(target, qNode.node);
                    weights.put(target, weight);
                }
            }
        }
        return new MSTResultList(parents, weights);
    }

    static class QNode implements Comparable<QNode> {
        public WNode node;
        public double weight;

        public QNode(WNode node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(QNode o) {
            return Double.compare(this.weight, o.weight);
        }
    }



    public static void main(String[] args) {

        // a0 b1 c2 d3 e4 f5 g6 h7 i8
        WAdjListGraph graph = new WAdjListGraph(9,
                new int[][]{
                        {0, 1}, // ab4
                        {0, 7}, // ah8
                        {1, 2}, // bc8
                        {1, 7}, // bh11
                        {2, 3},  // cd7
                        {2, 5}, // cf4
                        {2, 8}, // ci2
                        {3, 4}, // de9
                        {3, 5}, // df14
                        {4, 5}, // ef10
                        {5, 6}, // fg2
                        {6, 7}, // gh1
                        {6, 8}, // gi6
                        {7, 8} // hi7
                },
                new double[]{
                        4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 1, 6, 7
                },
                false);

        System.out.println(graph);

        MSTResultList result = new PrimMst().mst(graph.nodes);
        System.out.println(result);
    }


}
