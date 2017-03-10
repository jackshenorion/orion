package com.shenpinyi.utils.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jack on 10/03/2017.
 */
public class BinaryTreeTest {

    @Test
    public void testBuildBinaryTree() throws Exception {

        BinaryTreePrinter.printNode(
            new BinaryTree<String, Integer>(
                Arrays.asList(
                    new Entry<String, Integer>("A", 1, null),
                    new Entry<String, Integer>("B", 1, null),
                    new Entry<String, Integer>("D", 1, null),
                    null,
                    null,
                    new Entry<String, Integer>("E", 1, null),
                    new Entry<String, Integer>("G", 1, null),
                    null,
                    null,
                    null,
                    new Entry<String, Integer>("C", 1, null),
                    new Entry<String, Integer>("F", 1, null),
                    null,
                    null,
                    null
                )
            ).root);
    }


}