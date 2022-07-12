package com.sourav.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-if-path-exists-in-graph/
public class ValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){
            return true;
        }
        List<Integer>[] graph = new List[n];
        for (int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph, source, visited);
        return visited[destination];
    }

    public void dfs(List<Integer>[] graph, int s, boolean[] visited){
        visited[s] = true;
        for (int u: graph[s]){
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            dfs(graph, u, visited);
        }
    }
}
