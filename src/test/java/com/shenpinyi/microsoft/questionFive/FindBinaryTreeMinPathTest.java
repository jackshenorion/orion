package com.shenpinyi.microsoft.questionFive;

import com.shenpinyi.utils.tree.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindBinaryTreeMinPathTest {

    @Test
    public void testFindMinPath() throws Exception {
        FindBinaryTreeMinPath.findMinPath(new BinaryTree().add(10).add(5).add(12).add(4).add(7).add(11), 21);
    }
}