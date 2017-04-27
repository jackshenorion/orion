package com.shenpinyi.hackerrank.search;

/**
 * Created by jack on 27/04/2017.
 */
public class Indexing {

    /**
     * Hackerland Radio Transmitters
     * 分析: 这题貌似也没这么简单。因为还是不太容易想到使用的Search的知识点。
     * 比较容易想到的Naive的解法是对数组排序,然后逐个的去遍历house。
     * 这样的效率就不如Search范围内最远的house来的快。比如万一天线的范围很广,中间覆盖很多house,
     * 那么遍历数组和查找边界的效率就回差很多了。
     * 知识点:
     * 1 TreeSet可以用来保存排好序的集合;
     * 2 排好序的集合可以使用floor查找不大于指定一个点的最大的数, 而ceiling可以用来查找不小于某个点的最小的数
     * 3 虽然二分查询也支持在排好序的数组中查询数据,但是二分查询是查询是否存在,而不支持floor和ceiling
     *
     *
     */

}
