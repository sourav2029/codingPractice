package com.sourav.graph;


import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class WeightedGraph {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int s = flight[0];
            int d = flight[1];
            int w = flight[2];
            graph[s].add(new Pair(d, w));
        }
        return 0;
    }
}
