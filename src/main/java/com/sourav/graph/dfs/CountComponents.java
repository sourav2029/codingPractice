package com.sourav.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class CountComponents {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = createGraph(n, edges);
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i, graph, visited);
            }
        }
        return ans;
    }

    public void dfs(int i, List<Integer>[] graph, boolean[] visited) {
        visited[i] = true;
        for (int adj : graph[i]) {
            if (!visited[adj])
                dfs(adj, graph, visited);
        }
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


