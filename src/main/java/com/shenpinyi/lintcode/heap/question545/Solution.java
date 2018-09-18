package com.shenpinyi.lintcode.heap.question545;

import java.util.*;

public class Solution {

    private Queue<Integer> queue;
    private int k;
    /*
     * @param k: An integer
     */
    public Solution(int k) {
        this.queue = new PriorityQueue<>();
        this.k = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        if (queue.size() < k) {
            queue.offer(num);
        } else {
            if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            result.add(iterator.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;

    }

}
