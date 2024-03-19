package com.sourav.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPairs {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = createGraph(n, edges);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int dfs = dfs(i, graph, visited);
                ans += sum * dfs;
                sum += dfs;
            }
        }
        return ans;
    }

    public int dfs(int u, List<Integer>[] graph, boolean[] visited) {
        int ans = 1;
        visited[u] = true;
        for (int adj : graph[u]) {
            if (!visited[adj]) {
                ans += dfs(adj, graph, visited);
            }
        }
        return ans;
    }

    public List<Integer>[] createGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
