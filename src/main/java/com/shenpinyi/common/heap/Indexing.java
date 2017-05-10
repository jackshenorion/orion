package com.shenpinyi.common.heap;

/**
 * Created by jack on 7/05/2017.
 */
public class Indexing {
    /**
     * Heap的主要特征是它是满二叉树,它的不变的性质就是父节点比子节点小(最小堆)
     * 那么后面每次操作都必须要维持这种操作。
     *
     * 满二叉树的特点是,如果root节点在数组中的index是0, 某个节点在数组中的index是i,
     * 那么它的左子节点是i * 2 + 1, 右子节点是i * 2 + 2, 父节点是(i - 1) / 2
     *
     * heap使用heapfyup和heapfydown来维持不变性
     *
     */


}
