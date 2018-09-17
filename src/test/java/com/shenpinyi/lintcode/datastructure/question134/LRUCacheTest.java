package com.shenpinyi.lintcode.datastructure.question134;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void set() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        lruCache.get(2);
        lruCache.set(4,1);
        lruCache.get(1);
        lruCache.get(2);

    }
}