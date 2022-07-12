package com.sourav.unionfind;

import java.util.ArrayList;
import java.util.List;

public class CountPairs2 {
    int[] parent;
    long[] size;
    public long countPairs(int n, int[][] edges) {
        size = new long[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1L;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        List<Long> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                sizes.add(size[i]);
            }
        }
        long len = n;
        long ans = 0;
        for (int i = 0; i < sizes.size(); i++) {
            len -= sizes.get(i);
            ans += len * sizes.get(i);
        }
        return ans;
    }

    public int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (v == u) {
            return;
        }
        if (size[u] >= size[v]) {
            parent[v] = u;
            size[u] += size[v];
        } else {
            parent[u] = v;
            size[v] += size[u];
        }
    }
}
