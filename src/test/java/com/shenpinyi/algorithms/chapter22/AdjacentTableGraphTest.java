package com.shenpinyi.algorithms.chapter22;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by sj on 2017/3/5.
 */
public class AdjacentTableGraphTest {
    @Test
    public void getBFS() throws Exception {
        AdjacentTableGraph<String, Integer>  graph = new GraphBuilder<String, Integer>()
                .setVertexs(
                        Arrays.asList(
                                new Vertex<String>().setValue("0"),
                                new Vertex<String>().setValue("1"),
                                new Vertex<String>().setValue("2"),
                                new Vertex<String>().setValue("3"),
                                new Vertex<String>().setValue("4"),
                                new Vertex<String>().setValue("5"),
                                new Vertex<String>().setValue("6")
                        )
                )
                .setEdges(
                        Arrays.asList(
                                new Edge<Integer>().setCost(1).setSource(1).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(1).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(5),
                                new Edge<Integer>().setCost(1).setSource(3).setTarget(6),
                                new Edge<Integer>().setCost(1).setSource(3).setTarget(5),
                                new Edge<Integer>().setCost(1).setSource(4).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(6).setTarget(6)
                        )
                )
                .buildAdjacentTableGraph()
                ;
        System.out.println(graph.toString());
        BFS bfs = graph.getBFS(3);
        System.out.println(bfs);
    }

    @Test
    public void getBFS01() throws Exception {
        AdjacentTableGraph<String, Integer>  graph = new GraphBuilder<String, Integer>()
                .setVertexs(
                        Arrays.asList(
                                new Vertex<String>().setValue("r"),
                                new Vertex<String>().setValue("s"),
                                new Vertex<String>().setValue("t"),
                                new Vertex<String>().setValue("u"),
                                new Vertex<String>().setValue("v"),
                                new Vertex<String>().setValue("w"),
                                new Vertex<String>().setValue("x"),
                                new Vertex<String>().setValue("y")
                        )
                )
                .setEdges(
                        Arrays.asList(
                                new Edge<Integer>().setCost(1).setSource(0).setTarget(1).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(0).setTarget(4).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(1).setTarget(5).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(2).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(6).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(6).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(3).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(6).setTarget(3).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(6).setTarget(7).setHasDirection(false),
                                new Edge<Integer>().setCost(1).setSource(3).setTarget(7).setHasDirection(false)
                        )
                )
                .buildAdjacentTableGraph()
                ;
        System.out.println(graph.toString());
        BFS bfs = graph.getBFS(1);
        System.out.println(bfs);
    }
}