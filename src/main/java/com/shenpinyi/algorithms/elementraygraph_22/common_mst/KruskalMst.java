package com.shenpinyi.algorithms.elementraygraph_22.common_mst;

import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.MSTResultList;
import com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph.WNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KruskalMst {

    public MSTResultList mst(List<WNode> nodes) {
        Map<WNode, Double> weights = new HashMap<>();
        Map<WNode, WNode> parents = new HashMap<>();








        return new MSTResultList(parents, weights);
    }


}
