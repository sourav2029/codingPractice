package com.sourav.graph.bfs;

import java.util.*;

public class SafestPathInAGrid {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    bfs(dist, i, j, grid);
                }
            }
        }

        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
//        First argument minus second argument produces min priority queue
//        Second argument minus first argument produces max priority queue
        pq.add(new int[]{dist[0][0], 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == n - 1 && curr[2] == n - 1) {
                return curr[0];
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr[1] + dx[i];
                int ny = curr[2] + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    pq.add(new int[]{Math.min(dist[nx][ny], curr[0]), nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n);
    }


    public static void bfs(int[][] dist, int x, int y, List<List<Integer>> grid) {
        int n = grid.size();
        Queue<int[]> q = new LinkedList<>();
        dist[x][y] = 0;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] currCell = q.poll();
            int cx = currCell[0];
            int cy = currCell[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(nx, ny) && dist[nx][ny] > dist[cx][cy] + 1) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            input.add(new ArrayList<>());
        }
        input.get(0).add(0);
        input.get(0).add(0);
        input.get(0).add(0);
        input.get(0).add(1);

        input.get(1).add(0);
        input.get(1).add(0);
        input.get(1).add(0);
        input.get(1).add(0);

        input.get(2).add(0);
        input.get(2).add(0);
        input.get(2).add(0);
        input.get(2).add(0);

        input.get(3).add(1);
        input.get(3).add(0);
        input.get(3).add(0);
        input.get(3).add(0);

        System.out.println(maximumSafenessFactor(input));
    }

}
