package com.sourav.graph;

public class IslandPerimeter {
    int[] rows = {1, 0, -1, 0};
    int[] cols = {0, 1, 0, -1};
    int m,n;
    int ans;
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j]==1) {
                    dfs(grid, visited, i, j);
                }
            }
        }
        return ans;
    }

    private void  dfs(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + rows[k];
            int y = j + cols[k];

            if (x >= 0 && y >= 0 && x<m && y< n) {
                if (grid[x][y] == 1 && !visited[x][y]){
                    dfs(grid, visited, x, y);
                } else if (grid[x][y] == 0){
                    ans++;
                }
            } else {
                ans++;
            }
        }
    }
}
