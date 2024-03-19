package com.sourav.graph.dfs;

public class CountSubIsland {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int n, m;
    boolean flag;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid2.length;
        m = grid2[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    flag = true;
                    dfs(i, j, grid2, grid1);
                    if (flag) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][] grid2, int[][] grid1) {
        if (grid1[i][j] == 0) {
            flag = false;
        }
        grid2[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < n && y < m && grid2[x][y] == 1) {
                dfs(x, y, grid2, grid1);
            }
        }
    }
}
