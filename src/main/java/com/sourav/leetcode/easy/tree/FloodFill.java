package com.sourav.leetcode.easy.tree;


//https://leetcode.com/problems/flood-fill/
public class FloodFill {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int m, n;
    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int color) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int x = row+ dx[i];
            int y = col+ dy[i];
            if (x>=0 && y>=0 && x<m && y<n && !visited[x][y] && image[x][y] == image[row][col]){
                dfs(image, x, y, color);
            }
        }
        image[row][col] = color;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(image, 1,1,2);
    }
}
