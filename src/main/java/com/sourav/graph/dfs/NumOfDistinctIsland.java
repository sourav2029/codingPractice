package com.sourav.graph.dfs;

import java.util.HashSet;
import java.util.Set;

public class NumOfDistinctIsland {
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};
    char[] dirs = {'D', 'R', 'L', 'U'};
    int n, m;

    public int numDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder currentIsland = new StringBuilder();
                    dfs(i, j, grid, '0', currentIsland);
                    islands.add(currentIsland.toString());
                }
            }
        }
        return islands.size();
    }

    public void dfs(int i, int j, int[][] grid, char dir, StringBuilder currentIslands) {
        grid[i][j] = 0;
        currentIslands.append(dir);
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                dfs(x, y, grid, dirs[k], currentIslands);
            }
        }
        currentIslands.append('0');
    }

}
