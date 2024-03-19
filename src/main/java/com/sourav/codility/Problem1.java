package com.sourav.codility;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] visited;

    public static int solution(int N, int M, int[] X1, int[] Y1, int[] X2, int[] Y2) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited = new int[N][M];
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == N - 1 && curr[1] == M - 1) {
                return curr[2];
            }
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                if (isValid(x, y, N, M, X1, Y1, X2, Y2)) {
                    visited[x][y] = 1;
                    q.add(new int[]{x, y, curr[2] + 1});
                }
            }
        }
        return -1;
    }


    public static boolean isValid(int x, int y, int N, int M, int[] X1, int[] Y1, int[] X2, int[] Y2) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }
        if (visited[x][y] == 1) {
            return false;
        }
        int r = X1.length;
        for (int i = 0; i < r; i++) {
            if ((X1[i] <= x && x <= X2[i]) && (Y1[i] <= y && y <= Y2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 4, new int[]{2, 1, 4}, new int[]{0, 1, 3}, new int[]{2, 3, 4}, new int[]{2, 1, 3}));
        System.out.println(solution(500, 500, new int[]{2, 1, 4}, new int[]{0, 1, 3}, new int[]{2, 3, 4}, new int[]{2, 1, 3}));

    }
}
