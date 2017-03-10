package com.shenpinyi.microsoft.questionFive;

import com.shenpinyi.utils.tree.BinarySearchTree;
import org.junit.Test;

public class FindBinaryTreeMinPathTest {

    @Test
    public void testFindMinPath() throws Exception {
        FindBinaryTreeMinPath.findMinPath(new BinarySearchTree().add(10).add(5).add(12).add(4).add(7).add(11), 21);
    }
}