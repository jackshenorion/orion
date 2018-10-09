package com.shenpinyi.algorithms.elementraygraph_22.datastructure.graph;

import java.util.Arrays;

public class DfsResult {
    private int[] discoveryTimes;
    private int[] finishTimes;
    private int[] parents;

    public DfsResult(int[] discoveryTimes, int[] finishTimes, int[] parents) {
        this.discoveryTimes = discoveryTimes;
        this.finishTimes = finishTimes;
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "DfsResult{" +
                "discoveryTimes=" + Arrays.toString(discoveryTimes) +
                ", finishTimes=" + Arrays.toString(finishTimes) +
                ", parents=" + Arrays.toString(parents) +
                '}';
    }
}
