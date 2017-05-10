package com.shenpinyi.common.heap;

/**
 * Created by jack on 7/05/2017.
 */
public class Heap {

    private int[] items;
    private int DefaultCapacity = 10;

    public Heap(int capacity) {
        items = new int[capacity];
    }

    public Heap() {
        items = new int[DefaultCapacity];
    }


}
