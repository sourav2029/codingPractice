package com.sourav.graph;

import java.util.ArrayList;
import java.util.List;

public class CountPairs {
    long count;
    boolean[] visited;

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            graph[to].add(from);
            graph[from].add(to);
        }

        visited = new boolean[n];
        long ans = 0;
        int len = n;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count = 0;
                dfs(i, graph);
                ans+= (len-count)*count;
                len-= count;
            }
        }
        return ans;
    }

    public void dfs(int u, List<Integer>[] graph) {
        visited[u] = true;
        count++;
        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(v, graph);
            }
        }
    }
}
