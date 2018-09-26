package com.shenpinyi.lintcode.graph.question137;

import com.shenpinyi.lintcode.graph.UndirectedGraphNode;

import java.util.*;

public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // iterate all nodes, create label->adj labels
        HashMap<Integer, List<Integer>> adjacents = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            adjacents.putIfAbsent(cur.label, new ArrayList<>());
            for (UndirectedGraphNode adjNode : cur.neighbors) {
                adjacents.get(cur.label).add(adjNode.label);
                if (!adjacents.containsKey(adjNode.label)) {
                    queue.offer(adjNode);
                }
            }
        }
        // create map of label->adj nodes
        Map<Integer, UndirectedGraphNode> newNodes = new HashMap<>();
        for (Integer label : adjacents.keySet()) {
            newNodes.put(label, new UndirectedGraphNode(label));
        }
        // create new graph
        for (Integer label : adjacents.keySet()) {
            UndirectedGraphNode newNode = newNodes.get(label);
            List<Integer> adjs = adjacents.get(label);
            for (Integer adj : adjs) {
                newNode.neighbors.add(newNodes.get(adj));
            }
        }
        return newNodes.get(node.label);
    }

}
