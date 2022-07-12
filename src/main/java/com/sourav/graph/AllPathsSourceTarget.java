package com.sourav.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/
public class AllPathsSourceTarget {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;

        List<Integer>[] g = new List[len];
        for (int i = 0; i < len; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                g[i].add(graph[i][j]);
            }
        }
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[len];
        path.add(0);
        visited[0] = true;
        dfs(g, path, visited, 0, len - 1);
        return res;
    }

    private void dfs(List<Integer>[] g, List<Integer> path, boolean[] visited, int v, int dest) {
        if (v == dest) {
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<path.size(); i++){
                list.add(path.get(i));
            }
            res.add(list);
            return;
        }
        for (int u : g[v]) {
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            path.add(u);
            dfs(g, path, visited, u, dest);
            path.remove(path.size()-1);
            visited[u] = false;
        }
    }
}
