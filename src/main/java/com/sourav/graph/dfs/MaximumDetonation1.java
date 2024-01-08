package com.sourav.graph.dfs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/detonate-the-maximum-bombs/description/
public class MaximumDetonation1 {

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
        for (int neighbour : graph[bomb]) {
            if (!visited[neighbour]) {
                res += dfs(neighbour, visited);
            }
        }
        return res;
    }

    public boolean inRange(int a, int b, int r, int c, int d) {
        long dist = (long) (c - a) * (c - a) + (long) (d - b) * (d - b);
        return ((long) r * r) >= dist;
    }

}
