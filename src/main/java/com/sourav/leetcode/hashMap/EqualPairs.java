package com.sourav.leetcode.hashMap;

import java.util.Arrays;

public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] transpose = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                transpose[i][j] = grid[j][i];
            }
        }

        int count = 0;
        for(int[] row : grid){
            for(int[] col : transpose){
                if(Arrays.equals(row, col)){
                    count++;
                }
            }
        }
        return count;
    }
}
