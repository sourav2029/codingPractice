package com.sourav.graph;

public class ColorBorders {
    static int[] rows = {1, 0, -1, 0};
    static int[] cols = {0, 1, 0, -1};
    static int m,n;
    static boolean[][] visited;

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        dfs(row, col, grid, color);
        return grid;
    }

    public static void dfs(int row, int col, int[][] grid, int color) {
        visited[row][col] = true;
        System.out.println(row + "," + col);
        for (int k = 0; k < 4; k++) {
            int x = row + rows[k];
            int y = col + cols[k];

            if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[row][col] == grid[x][y]) {
                System.out.println(row + "," + col);
                dfs(x, y, grid, color);
            }
        }
        grid[row][col] = color;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,2},{2,3,2}};
        int row = 0, col = 1, color = 3;
        colorBorder(grid, row, col, color);
    }
}
