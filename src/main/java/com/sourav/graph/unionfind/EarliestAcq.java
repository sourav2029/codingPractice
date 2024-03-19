package com.sourav.graph.unionfind;

import java.util.Arrays;

//https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
public class EarliestAcq {
    static int[] parent, rank;

    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] log : logs) {
            union(log[1], log[2]);
            if (connectedComponentCount(n) == 1) {
                return log[0];
            }
        }
        return connectedComponentCount(n) > 1 ? -1 : logs[n - 1][0];
    }

    public static int connectedComponentCount(int n) {
        int ans = 2;
        for (int i = 0; i < n; i++) {
            if (rank[i] == n) {
                ans--;
            }
        }
        return ans;
    }

    public static void union(int u, int v) {
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

    public static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public static void main(String[] args) {
        System.out.println(earliestAcq(new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}}, 6));
    }

}
