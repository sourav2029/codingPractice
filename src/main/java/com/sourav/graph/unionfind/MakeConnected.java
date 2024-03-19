package com.sourav.graph.unionfind;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class MakeConnected {
    int[] parent;
    int[] rank;
    int connectedComp;
    int additionalEdges;
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];

        for (int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        additionalEdges = 0;
        connectedComp = n;
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        if (additionalEdges >= connectedComp - 1){
            return connectedComp-1;
        }

        return -1;
    }

    public int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public void union(int u, int v) {
        int rootu = find(u);
        int rootv = find(v);

        if (rootv == rootu) {
            additionalEdges++;
            return;
        }
        connectedComp--;
        if (rank[rootv] > rank[rootu]) {
            parent[rootu] = rootv;
            rank[rootu] += rank[rootv];
        } else {
            parent[rootv] = rootu;
            rank[rootv] += rank[rootu];
        }
    }
}
