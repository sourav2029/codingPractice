package com.sourav.graph.unionfind;

public class NumIslands {
    static int[] parent;
    static int[] rank;
    static int[] rows = {0, -1, 0, 1};
    static int[] cols = {1, 0, 1, 0};

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int elem = m * n;
        parent = new int[elem];
        rank = new int[elem];

        for (int i = 0; i < elem; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = i * (m-1) + j;
                for (int k=0; k<4; k++){
                    int x = i+ rows[k];
                    int y = j+ cols[k];
                    if (x >= 0 && y >= 0 && x <m && y < n && grid[x][y] == '1'){
                        int next = x*(m-1)+y;
                        union(curr, next);
                    }
                }
            }
        }

        int ans = 0;
        for (int i=0; i<elem; i++){
            if (i == parent[i]){
                ans++;
            }
        }
        return ans;
    }

    public static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return;
        }

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
            rank[pu] += rank[pv];
        } else {
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
    }


    public static void main(String[] args) {
        char[][] grid = { {'1'}, {'1'} };
        System.out.println(numIslands(grid));
    }

}
