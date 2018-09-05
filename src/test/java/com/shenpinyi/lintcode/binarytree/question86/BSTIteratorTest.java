package com.shenpinyi.lintcode.binarytree.question86;

import com.shenpinyi.lintcode.binarytree.TreeNode;
import com.shenpinyi.lintcode.binarytree.TreeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BSTIteratorTest {

    @Test
    public void next() {
        TreeNode root = TreeUtils.createTree(new int[]{10, 1, 11, Integer.MIN_VALUE, 6, Integer.MIN_VALUE, 12});
        BSTIterator bstIterator = new BSTIterator(root);
        List<Integer> results = new ArrayList<>();
        while (bstIterator.hasNext()) {
            results.add(bstIterator.next().val);
        }
        assertArrayEquals(new Integer[]{1, 6, 10, 11, 12}, results.toArray());
    }
}