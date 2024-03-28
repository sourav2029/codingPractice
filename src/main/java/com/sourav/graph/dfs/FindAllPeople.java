package com.sourav.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-people-with-secret/description/
public class FindAllPeople {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]>[] graph = createWeightedGraph(meetings, n);
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[0] = 0;
        visited[firstPerson] = 0;
        dfs(graph, 0, 0, visited);
        dfs(graph, firstPerson, 0, visited);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }

    public void dfs(List<int[]>[] graph, int node, int currTime, int[] visited) {
        for (int[] adj : graph[node]) {
            if (adj[1] >= currTime && visited[adj[0]] > adj[1]) {
                visited[adj[0]] = adj[1];
                dfs(graph, adj[0], adj[1], visited);
            }
        }
    }

    public List<int[]>[] createWeightedGraph(int[][] meetings, int n) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] meeting : meetings) {
            int p0 = meeting[0];
            int p1 = meeting[1];
            int time = meeting[2];
            graph[p0].add(new int[]{p1, time});
            graph[p1].add(new int[]{p0, time});
        }
        return graph;
    }
}
