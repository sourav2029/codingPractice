package com.sourav.graph;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/detonate-the-maximum-bombs/
public class MaximumDetonations {
    List<Integer>[] graph;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int r1 = bombs[i][2];
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                if (inRange(x1, y1, r1, x2, y2)) {
                    graph[i].add(j);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            ans = Math.max(ans, dfs(i, visited));
        }
        return ans;


    }
    public int dfs(int bomb, boolean[] visited) {
        int res = 1;
        visited[bomb] = true;
        for (int neighbor : graph[bomb]) {
            if (!visited[neighbor]) {
                res += dfs(neighbor, visited);
            }
        }
        return res;
    }

    public boolean inRange(int a, int b, int r1, int c, int d) {
        long dist = (long) (c - a) * (c - a) + (long) (d - b) * (d - b);
        return (long) r1 * r1 >= dist;
    }


    public static void main(String[] args) {
        int[][] bombs = new int[][] {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        MaximumDetonations maximumDetonations = new MaximumDetonations();
        System.out.println(maximumDetonations.maximumDetonation(bombs));
    }
}
