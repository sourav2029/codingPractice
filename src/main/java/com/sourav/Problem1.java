package com.sourav;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    public boolean solution(int N, int[] A, int[] B) {
        // Implement your solution here
        List<Integer>[] graph = createUndirectedGraph(N, A, B);
        return dfs(1, graph, N);
    }


    public boolean dfs(int node, List<Integer>[] graph, int N){
        if (node == N){
            return true;
        }
        for(int adj : graph[node]){
            if(adj == node+1){
                return dfs(adj, graph, N);
            }
        }
        return false;
    }

    public List<Integer>[] createUndirectedGraph(int N, int[] A, int[] B){
        List<Integer>[] graph = new List[N];
        for(int i=0; i<N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<A.length; i++){
            int st = A[i];
            int end = B[i];
            graph[st].add(end);
            graph[end].add(st);
        }
        return graph;
    }
}
