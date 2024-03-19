package com.sourav.graph.unionfind;

public class ConnectedComponents {
    int[] parent;
    int[] rank;

    public int connectedComponents(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        int connectedComp = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                connectedComp++;
            }
        }
        return connectedComp;
    }


    public int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public void union(int u, int v) {
        int rootu = find(u);
        int rootv = find(v);

        if (rootu == rootv) {
            return;
        }

        if (rank[rootu] > rank[rootv]) {
            parent[rootv] = rootu;
            rank[rootu] += rank[rootv];
        } else {
            parent[rootu] = rootv;
            rank[rootv] += rank[rootu];
        }
    }
}
