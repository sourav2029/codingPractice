package com.sourav.graph.dfs;

import java.util.Arrays;

public class ClosedIsland {
    int[] dx = { 0, 1, -1, 0 };
    int[] dy = { 1, 0, 0, -1 };
    int[][] visited;
    int m,n;
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 0 && visited[i][j] == 0) {
                        dfs(grid, i, j);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j) {
        visited[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0 && visited[x][y] == 0) {
                dfs(grid, x, y);
            }
        }
    }

    public static void main(String[] args) {
        ClosedIsland closedIsland = new ClosedIsland();
        System.out.println(closedIsland.closedIsland(new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}}));
    }
}
