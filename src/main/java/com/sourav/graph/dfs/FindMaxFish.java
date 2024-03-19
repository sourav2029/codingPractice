package com.sourav.graph.dfs;

import java.util.Arrays;

public class FindMaxFish {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int n, m;

    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        int maxFishCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int currFishCount = dfs(i, j, grid);
                    maxFishCount = Math.max(maxFishCount, currFishCount);
                }
            }
        }
        return maxFishCount;
    }

    public int dfs(int i, int j, int[][] grid) {
        visited[i][j] = true;
        int fishCount = grid[i][j];
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && grid[x][y] != 0) {
                fishCount += dfs(x, y, grid);
            }
        }
        return fishCount;
    }
}
