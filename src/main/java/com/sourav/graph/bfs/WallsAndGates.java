package com.sourav.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    int m, n;

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int dist = curr[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && y >= 0 && x < m && y < n && rooms[x][y] > dist + 1) {
                    rooms[x][y] = dist + 1;
                    q.add(new int[]{x, y, dist + 1});
                }
            }
        }
    }
}
