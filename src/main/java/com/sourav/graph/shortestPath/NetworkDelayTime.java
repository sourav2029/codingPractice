package com.sourav.graph.dijkstras;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


// Dijaksta Algorithm to implement
public class NetworkDelayTime {

    record Cell(int i, int w, int k) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        List<Pair>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            list[s].add(new Pair(w, d));
        }
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, k));
        while (!pq.isEmpty()) {
            int a = pq.poll().second;
            if (visited[a])
                continue;
            visited[a] = true;
            for (Pair pair : list[a]) {
                int b = pair.second;
                int w = pair.first;
                if (distance[a] + w < distance[b]) {
                    distance[b] = distance[a] + w;
                    pq.add(new Pair(distance[b], b));
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}