package com.sourav.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-groups-of-farmland/

public class FindFarmLand {
    int[] dx = {1, 0};
    int[] dy = {0, 1};
    boolean[][] visited;
    int n, m;

    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] curr = new int[4];
                    curr[0] = i;
                    curr[1] = j;
                    dfs(i, j, land, curr);
                    ans.add(curr);
                }

            }
        }
        int[][] res = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void dfs(int i, int j, int[][] land, int[] curr) {
        visited[i][j] = true;
        for (int k = 0; k < 2; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && land[x][y] == 1) {
                dfs(x, y, land, curr);
            }
        }
        curr[2] = Math.max(i, curr[2]);
        curr[3] = Math.max(j, curr[3]);
    }
}
