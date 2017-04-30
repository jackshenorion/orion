package com.shenpinyi.hackerrank.graphs.RoadsAndLibraries;

import java.util.*;

/**
 * Created by jack on 28/04/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int costOfLib = in.nextInt();
            int costOfRoad = in.nextInt();

            long totalCost = 0;
            if (costOfLib <= costOfRoad) {
                for(int a1 = 0; a1 < m; a1++){
                    int city_1 = in.nextInt() - 1;
                    int city_2 = in.nextInt() - 1;
                }
                totalCost = (long)n * (long)costOfLib;
            } else {
                /**
                 * 这里创建了一个使用邻接表表示的图。
                 * 注意Java创建范型数组的方式,创建一个不带范型的数组,然后强制转型。
                 */
                List<Integer>[] graph = (List<Integer>[]) new LinkedList[n];
                for(int i = 0; i < n; i ++) {
                    graph[i] = new LinkedList<>();
                }

                for(int a1 = 0; a1 < m; a1++){
                    int city_1 = in.nextInt() - 1;
                    int city_2 = in.nextInt() - 1;
                    addEdgeToGraph(graph, city_1, city_2); // 初始化无向图的边集合
                }

                /**
                 * 下面的算法值得注意。使用boolean数组而不是集合来记录顶点的访问情况其实效率更高。
                 * 因为初始化HashSet,查询,删除节点都需要时间。而visited数组遍历一遍也就是线性的时间。
                 * 一旦节点被访问过,那么visited就置为false了,不影响遍历的方向
                 */
                boolean[] visited = new boolean[n];
                Arrays.fill(visited, false);
                int numberOfConnectedComp = 0;
                for (int i = 0; i < n; i ++) {
                    if (!visited[i]) {
                        numberOfConnectedComp ++;
                        bfs(graph, i, visited);
                    }
                }
                totalCost = (long)numberOfConnectedComp * (long)costOfLib + (n - numberOfConnectedComp) * (long) costOfRoad;
            }
            System.out.println(totalCost);
        }
    }

    private static void addEdgeToGraph(List<Integer>[] graph, int v1, int v2) {
        graph[v1].add(v2);
        graph[v2].add(v1);
    }

    private static void bfs(List<Integer>[] graph, int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (q.size() != 0) {
            Integer s = q.poll();
            List<Integer> edges = graph[s];
            for (int i = 0; i < edges.size(); i ++) {
                Integer t = edges.get(i);
                if (!visited[t]) {
                    q.offer(t);
                    visited[t] = true;
                }
            }
        }
    }
}
