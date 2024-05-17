package com.sourav.graph.bfs;

import java.util.*;

public class MinHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        int[] degree = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            graph[s].add(d);
            graph[d].add(s);
            degree[s]++;
            degree[d]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }
        int remainingNodes = n;

        while (remainingNodes > 2) {
            int size = leaves.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                for (int adj : graph[leaf]) {
                    if (--degree[adj] == 1) {
                        leaves.add(adj);
                    }
                }
            }
        }
        return new ArrayList<>(leaves);
    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));

    }
}
