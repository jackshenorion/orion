<<<<<<< HEAD
package com.shenpinyi.algorithms.chapter22;

import org.junit.Test;

import java.util.Arrays;
=======
import static org.junit.Assert.*;
>>>>>>> dc3a43cecaa516033d9a02e119e17d1c2334b919

/**
 * Created by sj on 2017/3/4.
 */
public class GraphBuilderTest {
<<<<<<< HEAD
    @Test
    public void buildAdjacentTableGraph() throws Exception {
        String matrixDisplay = new GraphBuilder<String, Integer>()
                .setVertexs(
                        Arrays.asList(
                                new Vertex<String>().setValue("O"),
                                new Vertex<String>().setValue("A"),
                                new Vertex<String>().setValue("B"),
                                new Vertex<String>().setValue("C"),
                                new Vertex<String>().setValue("D"),
                                new Vertex<String>().setValue("E")
                        )
                )
                .setEdges(
                        Arrays.asList(
                                new Edge<Integer>().setCost(1).setSource(1).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(3),
                                new Edge<Integer>().setCost(1).setSource(1).setTarget(5),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(5),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(3).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(1),
                                new Edge<Integer>().setCost(1).setSource(3).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(1),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(4).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(4).setTarget(3),
                                new Edge<Integer>().setCost(1).setSource(4).setTarget(5)
                        )
                )
                .buildAdjacentTableGraph()
                .toString()
                ;

        System.out.println(matrixDisplay);

    }

    @Test
    public void build() throws Exception {
        String matrixDisplay = new GraphBuilder<String, Integer>()
                .setVertexs(
                        Arrays.asList(
                                new Vertex<String>().setValue("O"),
                                new Vertex<String>().setValue("A"),
                                new Vertex<String>().setValue("B"),
                                new Vertex<String>().setValue("C"),
                                new Vertex<String>().setValue("D"),
                                new Vertex<String>().setValue("E")
                                )
                )
                .setEdges(
                        Arrays.asList(
                                new Edge<Integer>().setCost(1).setSource(1).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(3),
                                new Edge<Integer>().setCost(1).setSource(1).setTarget(5),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(5),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(3).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(4),
                                new Edge<Integer>().setCost(1).setSource(2).setTarget(1),
                                new Edge<Integer>().setCost(1).setSource(3).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(1),
                                new Edge<Integer>().setCost(1).setSource(5).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(4).setTarget(2),
                                new Edge<Integer>().setCost(1).setSource(4).setTarget(3),
                                new Edge<Integer>().setCost(1).setSource(4).setTarget(5)
                        )
                )
                .buildAdjacentMatrixGraph()
                .toString()
        ;

        System.out.println(matrixDisplay);

    }
=======
>>>>>>> dc3a43cecaa516033d9a02e119e17d1c2334b919

}