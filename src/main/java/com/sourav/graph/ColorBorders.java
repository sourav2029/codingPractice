package com.sourav.graph;
//https://leetcode.com/problems/coloring-a-border/
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
        int count = 0;
        for(int k=0; k<4;k++){
            int x = row+rows[k];
            int y = col+cols[k];

            if (x>= 0 && y>=0 && x<m && y<n){
                if(grid[row][col] == grid[x][y]){
                    count++;
                    if(!visited[x][y]){
                        dfs(x,y,grid,color);
                    }
                } else if (visited[x][y] && grid[x][y] == color){
                    count++;
                }
            }
        }
        if (count != 4){
            grid[row][col] = color;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,1,1}, {1,1,1}};
        int row = 1, col = 1, color = 2;
        colorBorder(grid, row, col, color);
    }
}
