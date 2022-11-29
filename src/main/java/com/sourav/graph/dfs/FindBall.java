package com.sourav.graph.dfs;

public class FindBall {
    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] result = new int[cols];

        for(int i=0; i<cols; i++){
            result[i] = findBallDropColumn(0, i, grid);
        }
        return result;
    }

    public int findBallDropColumn(int row, int col, int[][] grid){
        if(row == grid.length){
            return col;
        }
        int nextColumn = col + grid[row][col];
        if(nextColumn <0 || nextColumn> grid[0].length-1 || grid[row][col] != grid[row][nextColumn]){
            return -1;
        }
        return findBallDropColumn(row+1, nextColumn, grid);
    }
}
