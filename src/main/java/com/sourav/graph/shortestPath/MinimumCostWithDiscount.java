package com.sourav.graph.dijkstras;

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

    public static void main(String[] args) {
        System.out.println(minimumCost(4, new int[][]{{1,3,17},{1,2,7},{3,2,5},{0,1,6},{3,0,20}}, 20));
        System.out.println(minimumCost(4, new int[][]{{1,3,17},{1,2,7},{3,2,5},{0,1,6},{3,0,20}}, 0));
    }
}
