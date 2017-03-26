package com.shenpinyi.microsoft.question015;

import com.shenpinyi.utils.tree.BinaryTree;
import com.shenpinyi.utils.tree.BinaryTreePrinter;
import com.shenpinyi.utils.tree.Entry;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jack on 15/03/2017.
 */
public class BinaryTreeFlipOverTest {

    @Test
    public void testFlipOver() throws Exception {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>(
            Arrays.asList(
                new Entry<Integer, Integer>(8, 8, null),
                new Entry<Integer, Integer>(6, 6, null),
                new Entry<Integer, Integer>(5, 5, null),
                null,
                null,
                new Entry<Integer, Integer>(7, 7, null),
                null,
                null,
                new Entry<Integer, Integer>(10, 10, null),
                new Entry<Integer, Integer>(9, 9, null),
                null,
                null,
                new Entry<Integer, Integer>(11, 11, null),
                null,
                null
            )
        );

        BinaryTreePrinter.printNode(tree.root);
        BinaryTreeFlipOver.flipOver(tree);
        BinaryTreePrinter.printNode(tree.root);
    }
}