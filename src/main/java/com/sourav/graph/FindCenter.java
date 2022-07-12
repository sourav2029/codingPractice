package com.sourav.graph;

import java.util.List;

//https://leetcode.com/problems/find-center-of-star-graph/
public class FindCenter {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] degree = new int[2 * n + 1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for (int i = 0; i < 2 * n + 1; i++) {
            if (degree[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
