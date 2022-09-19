package com.sourav.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};

    public class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int totalTime = 0;
        int countFresh = 0;

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    countFresh++;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int currRow = p.row;
            int currCol = p.col;
            int currTime = p.time;
            totalTime = Math.max(totalTime, currTime);
            for (int i = 0; i < 4; i++) {
                int x = currRow + dx[i];
                int y = currCol + dy[i];
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] == 1) {
                    q.offer(new Pair(x, y, currTime + 1));
                    visited[x][y] = true;
                    count++;
                }
            }
        }
        if (count < countFresh){
            return -1;
        }
        return totalTime;
    }
}
