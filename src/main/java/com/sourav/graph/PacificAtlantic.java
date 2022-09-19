//package com.sourav.graph;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PacificAtlantic {
//    int[] dx = {0, 1, -1, 0};
//    int[] dy = {1, 0, 0, -1};
//    boolean[][] visited;
//    int m, n;
//    boolean[][] isPacificReachable, isAtlanticReachable;
//
//    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        m = heights.length;
//        n = heights[0].length;
//        isAtlanticReachable = new boolean[m][n];
//        isPacificReachable = new boolean[m][n];
//        List<List<Integer>> ans = new ArrayList<>();
//
//        for (int i = 0; i < m; i++) {
//
//        }
//        for (int j = 0; j < n; j++) {
//            visited = new boolean[m][n];
//            dfs(heights, i, j);
//            if (isAtlanticReachable && isPacificReachable) {
//                List<Integer> curr = new ArrayList<>();
//                curr.add(i);
//                curr.add(j);
//                ans.add(curr);
//            }
//        }
//    }
//        return ans;
//}
//
//
//    public void dfs(int[][] height, int i, int j) {
//        visited[i][j] = true;
//        if (isPacific(i, j)) {
//            isPacificReachable = true;
//        }
//        if (isAtlantic(i, j)) {
//            isAtlanticReachable = true;
//        }
//        for (int k = 0; k < 4; k++) {
//            int x = i + dx[k];
//            int y = j + dy[i];
//
//            if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && height[x][y] < height[i][j]) {
//                dfs(height, x, y);
//            }
//        }
//    }
//
//
//    public boolean isPacific(int i, int j) {
//        if (i == 0 || j == 0) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isAtlantic(int i, int j) {
//        if (i == m - 1 || j == n - 1) {
//            return true;
//        }
//        return false;
//    }
//}
