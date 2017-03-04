<<<<<<< HEAD
package com.shenpinyi.algorithms.chapter22.excersice2216;

import com.shenpinyi.algorithms.chapter22.Edge;
import com.shenpinyi.algorithms.chapter22.GraphBuilder;
import com.shenpinyi.algorithms.chapter22.Vertex;
import org.junit.Test;

import java.util.Arrays;

=======
>>>>>>> dc3a43cecaa516033d9a02e119e17d1c2334b919
import static org.junit.Assert.*;

/**
 * Created by sj on 2017/3/5.
 */
public class UniversalSinkFinderTest {
<<<<<<< HEAD
    @Test
    public void find() throws Exception {
        System.out.print(
                new UniversalSinkFinder(
                        new GraphBuilder<String, Integer>()
                                .setVertexs(Arrays.asList(
                                        new Vertex<String>().setValue("A"),
                                        new Vertex<String>().setValue("B"),
                                        new Vertex<String>().setValue("C"),
                                        new Vertex<String>().setValue("D"),
                                        new Vertex<String>().setValue("E"),
                                        new Vertex<String>().setValue("F")
                                ))
                                .setEdges(Arrays.asList(
                                        new Edge<Integer>().setSource(0).setTarget(2).setCost(1),
                                        new Edge<Integer>().setSource(2).setTarget(5).setCost(1),
                                        new Edge<Integer>().setSource(5).setTarget(4).setCost(1),
                                        new Edge<Integer>().setSource(4).setTarget(1).setCost(1),
                                        new Edge<Integer>().setSource(1).setTarget(0).setCost(1),
                                        //new Edge<Integer>().setSource(3).setTarget(0).setCost(1),
                                        new Edge<Integer>().setSource(0).setTarget(3).setCost(1),
                                        new Edge<Integer>().setSource(1).setTarget(3).setCost(1),
                                        new Edge<Integer>().setSource(2).setTarget(3).setCost(1),
                                        new Edge<Integer>().setSource(4).setTarget(3).setCost(1),
                                        new Edge<Integer>().setSource(5).setTarget(3).setCost(1)
                                ))
                                .buildAdjacentMatrixGraph())
                        .find());
    }
=======
>>>>>>> dc3a43cecaa516033d9a02e119e17d1c2334b919

}