package com.sourav.graph.unionfind;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    int[] parent, rank;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int provinces = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    provinces -= union(i, j);
                }
            }
        }
        return provinces;
    }


    public int union(int u, int v) {
        int rootu = find(u);
        int rootv = find(v);
        if (rootu == rootv) {
            return 0;
        }

        if (rank[rootu] > rank[rootv]) {
            parent[rootv] = rootu;
            rank[rootu] += rank[rootv];
        } else {
            parent[rootu] = rootv;
            rank[rootv] += rank[rootu];
        }
        return 1;
    }

    public int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }



}
