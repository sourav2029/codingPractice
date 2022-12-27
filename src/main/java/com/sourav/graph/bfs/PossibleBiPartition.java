package com.sourav.graph.bfs;

import java.util.*;

public class PossibleBiPartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        int len = dislikes.length;
        for (int i = 0; i < len; i++) {
            int source = dislikes[i][0];
            int dest = dislikes[i][1];
            graph[source].add(dest);
            graph[dest].add(source);
        }
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                boolean ans = bfs(i, graph, colors);
                if (!ans) {
                    return ans;
                }
            }
        }
        return true;

    }

    public boolean bfs(int source, List<Integer>[] graph, int[] colors) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        colors[source] = 1;
        while (!q.isEmpty()) {
            int currNode = q.poll();
            int currColor = colors[currNode];
            for (int v : graph[currNode]) {
                if (colors[v] == -1) {
                    colors[v] = 1 - currColor;
                    q.add(v);
                } else if (colors[v] != 1 - currColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
