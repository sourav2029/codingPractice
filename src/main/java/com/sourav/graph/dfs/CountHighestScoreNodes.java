package com.sourav.graph.dfs;

import java.util.*;

public class CountHighestScoreNodes {
    int[] s;

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        List<Integer>[] graph = createGraph(parents);
        s = new int[n];
        dfs(graph, 0);
        int nodesWithMaxScore = 0;
        int maxScore = -1;
        for (int i = 0; i < n; i++) {
            if (s[i] > maxScore) {
                maxScore = s[i];
                nodesWithMaxScore = 1;
            } else if (s[i] == maxScore) {
                nodesWithMaxScore++;
            }
        }
        return nodesWithMaxScore;
    }

    public int dfs(List<Integer>[] graph, int curr) {
        int prod = 1;
        int sum = 1;
        for (int child : graph[curr]) {
            int count = dfs(graph, child);
            prod = prod * count;
            sum += count;
        }
        s[curr] = prod * Math.max(1, graph.length - sum);
        return sum;
    }

    public List<Integer>[] createGraph(int[] parent) {
        int n = parent.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                graph[parent[i]].add(i);
            }
        }
        return graph;
    }
}
