package com.shenpinyi.leecode.question133;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 27/03/2017.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
