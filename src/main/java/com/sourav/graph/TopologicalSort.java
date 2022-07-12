package com.sourav.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {

    static void dfs(List<Integer>[] graph, boolean[] used, List<Integer> res, int u ){
        used[u] = true;
        for (int v : graph[u]){
            if(!used[v]){
                dfs(graph, used, res, v);
            }
        }
        res.add(u);
    }

    public static List<Integer> topologicalSort(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!used[i]){
                dfs(graph, used, res, i);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < 3; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(0);
        graph[2].add(1);
        graph[0].add(1);

        List<Integer> res = topologicalSort(graph);
        System.out.println(res);
    }
}
