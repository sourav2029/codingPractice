package com.sourav.leetcode.backtracking;

public class PathWithMaximumGold {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int m, n, ans = 0;

    public static int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j, grid, 0);
                }
            }
        }
        return ans;
    }

    public static void dfs(int x, int y, int[][] grid, int currSum) {
        currSum += grid[x][y];
        int val = grid[x][y];
        grid[x][y] = 0;
        ans = Math.max(ans, currSum);
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 0) {
                dfs(nx, ny, grid, currSum);
            }
        }
        grid[x][y] = val;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGold(new int[][]{{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}}));
    }
}
