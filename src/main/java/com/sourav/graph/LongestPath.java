package com.sourav.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/
public class LongestPath {
    int ans = 0;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        int max = dfs(g, 0, s);
        return Math.max(ans, max);
    }


    public int dfs(List<Integer>[] g, int source, String s) {
        int adjCountMax = 0;
        int adjSecondMax = 0;
        for (int child : g[source]) {
            int adjCount = dfs(g, child, s);
            if (s.charAt(source) != s.charAt(child)) {
                if (adjCount > adjCountMax) {
                    adjSecondMax = adjCountMax;
                    adjCountMax = adjCount;
                } else if (adjCount > adjSecondMax) {
                    adjSecondMax = adjCount;
                }
                ans = Math.max(ans, adjCountMax + adjSecondMax + 1);
            } else {
                ans = Math.max(ans, adjCount);
            }
        }
        return adjCountMax + 1;
    }
}
