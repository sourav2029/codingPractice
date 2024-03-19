package com.sourav.unionfind;

public class UnionFind {
    static int[] parent, rank;

    public static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public static void union(int u, int v) {
        int rootu = find(u);
        int rootv = find(v);

        if (rootv == rootu) {
            return;
        }

        if (rank[rootu] >= rank[rootv]) {
            parent[rootv] = rootu;
            rank[rootu] += rank[rootv];
        } else {
            parent[rootu] = rootv;
            rank[rootv] += rank[rootu];
        }
    }


    public static void main(String[] args) {
        int[] elements = {1, 3, 4, 5, 6, 7, 8, 9};
        parent = new int[15];
        rank = new int[15];
        for (int i = 0; i < elements.length; i++) {
            parent[elements[i]] = elements[i];
            rank[elements[i]] = 1;
        }
        union(1, 8);
        union(8, 7);
        union(3, 1);
        System.out.println(find(7));
        System.out.println(find(1));
        System.out.println(find(3));
        union(9, 6);
        union(4, 5);
        union(5, 9);
        System.out.println(find(4));
        System.out.println(find(5));
        union(6, 3);
        System.out.println(find(4));
        System.out.println(find(5));
        System.out.println(find(6));
    }

}
