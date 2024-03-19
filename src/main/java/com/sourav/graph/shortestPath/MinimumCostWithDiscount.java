package com.sourav.graph.shortestPath;

import java.util.*;

public class MinimumCostWithDiscount {
    public static int minimumCost(int n, int[][] highways, int discounts) {
        int[][] dist = new int[n][discounts + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= discounts; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <= discounts; i++) {
            dist[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int[] highway : highways) {
                int a = highway[0];
                int b = highway[1];
                int toll = highway[2];
                for (int j = 0; j <= discounts; j++) {
                    if (dist[a][j] != Integer.MAX_VALUE) {
                        if (j == 0) {
                            dist[b][j] = Math.min(dist[a][j] + toll, dist[b][j]);
                            continue;
                        }
                        dist[b][j] = Math.min(dist[a][j - 1] + toll / 2, Math.min(dist[a][j] + toll, dist[b][j]));
                    }
                    if (dist[b][j] != Integer.MAX_VALUE) {
                        if (j == 0) {
                            dist[a][j] = Math.min(dist[b][j] + toll, dist[a][j]);
                            continue;
                        }
                        dist[a][j] = Math.min(dist[b][j - 1] + toll / 2, Math.min(dist[b][j] + toll, dist[a][j]));
                    }
                }
            }
        }
        return dist[n - 1][discounts] == Integer.MAX_VALUE ? -1 : dist[n - 1][discounts];
    }

//    public int minimumCost(int n, int[][] highways, int discounts) {
//        List<Pair>[] g = createGraph(n, highways);
//        int[][] visited = new int[n][discounts + 1];
//        Queue<PairWithDiscount> q = new PriorityQueue<>();
//        q.offer(new PairWithDiscount(0, 0, discounts));
//        for (int[] arr : visited) {
//            Arrays.fill(arr, Integer.MAX_VALUE);
//        }
//
//        while (!q.isEmpty()) {
//            PairWithDiscount entry = q.poll();
//            if (entry.first == n - 1) {
//                return entry.first;
//            }
//            if (entry.k > 0) {
//                int k2 = entry.k - 1;
//                for (Pair p : g[entry.first]) {
//                    int w2 = p.first / 2 + entry.second;
//                    if (w2 < visited[p.first][k2]) {
//                        visited[p.first][k2] = w2;
//                        q.offer(new PairWithDiscount(w2, p.first, k2));
//                    }
//                }
//            }
//            for(Pair p : g[entry.first]){
//                int w2 = p.first + entry.second;
//                if (w2 < visited[p.first][entry.k]) {
//                    visited[p.first][entry.k] = w2;
//                    q.offer(new PairWithDiscount(w2,p.first entry.k);
//                }
//            }
//        }
//        return -1;
//    }

    public List<Pair>[] createGraph(int n, int[][] edges) {
        List<Pair>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(new Pair(edge[1], edge[2]));
            g[edge[1]].add(new Pair(edge[0], edge[2]));
        }
        return g;
    }


    public static void main(String[] args) {
        System.out.println(minimumCost(4, new int[][]{{1, 3, 17}, {1, 2, 7}, {3, 2, 5}, {0, 1, 6}, {3, 0, 20}}, 20));
        System.out.println(minimumCost(4, new int[][]{{1, 3, 17}, {1, 2, 7}, {3, 2, 5}, {0, 1, 6}, {3, 0, 20}}, 0));
    }
}
