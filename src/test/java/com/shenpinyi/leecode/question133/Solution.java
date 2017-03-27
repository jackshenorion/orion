package com.shenpinyi.leecode.question133;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by jack on 27/03/2017.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, UndirectedGraphNode> newNodes = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();

        // create the root node
        UndirectedGraphNode newGraph = new UndirectedGraphNode(node.label);
        queue.add(node);
        newNodes.put(node.label, newGraph);

        while (queue.size() != 0) {
            UndirectedGraphNode vOld = queue.removeFirst();
            UndirectedGraphNode vNew = newNodes.get(vOld.label);
            for (int i = 0; i < vOld.neighbors.size(); i++) {
                UndirectedGraphNode uOld = vOld.neighbors.get(i);
                UndirectedGraphNode uNew = newNodes.get(uOld.label);

                if (uNew == null) { // white node
                    uNew = new UndirectedGraphNode(uOld.label);
                    newNodes.put(uNew.label, uNew);
                    queue.add(uOld);
                }

                vNew.neighbors.add(uNew);
            }
        }
        return newGraph;
    }

    public static String serialize(UndirectedGraphNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        HashMap<Integer, Integer> color = new HashMap<>();
        color.put(node.label, 1); // mark as grey

        while (queue.size() != 0) {
            UndirectedGraphNode vOld = queue.removeFirst();
            builder.append(vOld.label);
            for (int i = 0; i < vOld.neighbors.size(); i++) {
                UndirectedGraphNode uOld = vOld.neighbors.get(i);
                Integer uColor = color.get(uOld.label);
                if (uColor == null) {
                    queue.add(uOld);
                    color.put(uOld.label, 1);
                }
                builder.append("," + uOld.label);
            }
            builder.append("#");
        }

        return builder.toString();
    }

    /**
     *
     * @param g e.g.{0,1,2#1,2#2,2}
     * @return first node
     */
    public static UndirectedGraphNode unserialize(String g) {
        StringTokenizer tokenizer = new StringTokenizer(g, "#");
        HashMap<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        UndirectedGraphNode s = null;
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            String[] vs = token.split(",");
            int vLabel = Integer.valueOf(vs[0]);
            UndirectedGraphNode v = nodes.get(vLabel);
            if (v == null) {
                v = new UndirectedGraphNode(vLabel);
                nodes.put(vLabel, v);
            }

            if (s == null) {
                s = v;
            }

            for (int i = 1; i < vs.length; i++) {
                int uLabel = Integer.valueOf(vs[i]);
                UndirectedGraphNode u = nodes.get(uLabel);
                if (u == null) {
                    u = new UndirectedGraphNode(uLabel);
                    nodes.put(uLabel, u);
                }
                v.neighbors.add(u);
            }
        }

        return s;
    }
}
