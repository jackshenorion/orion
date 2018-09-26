package com.shenpinyi.lintcode.graph.question127;

import com.shenpinyi.lintcode.graph.DirectedGraphNode;

import java.util.*;

public class Solution {


    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // find out which node is the start node
        if (graph == null || graph.size() == 0) {
            return null;
        }
        DirectedGraphNode root = getStartNode(graph);
        // use bfs to find out the order
        Set<DirectedGraphNode> touched = new HashSet<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        queue.offer(root);
        touched.add(root);
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            DirectedGraphNode cur = queue.poll();
            result.add(cur);
            for (DirectedGraphNode adj : cur.neighbors) {
                if (!touched.contains(adj)) {
                    queue.offer(adj);
                    touched.add(adj);
                }
            }
        }
        return result;
    }

    private DirectedGraphNode getStartNode(ArrayList<DirectedGraphNode> graph) {

        // check all node, if any node has incoming edge, mark it
        Set<DirectedGraphNode> nodes = new HashSet<>();
        for (DirectedGraphNode node : graph) {
            nodes.add(node);
        }
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode adj : node.neighbors) {
                nodes.remove(adj);
            }
        }
        return nodes.iterator().next();
    }

}
