package com.sourav.graph.dijkstras;

import java.util.*;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class FindCheapestFlight {
    //    Bellman ford algorithm
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(distance, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if (distance[s] != Integer.MAX_VALUE) {
                    temp[d] = Math.min(distance[s] + p, temp[d]);
                }
            }
            distance = temp;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

//    BFS approach

    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        List<Pair>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int s = flight[0];
            int d = flight[1];
            int w = flight[2];
            graph[s].add(new Pair(d, w));
        }
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new Pair(src, 0));
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.poll();
                int a = p.first;
                int cost = p.second;
                for (Pair pair : graph[a]) {
                    int b = pair.first;
                    int price = pair.second;
                    if (dist[b] > cost + price) {
                        dist[b] = cost + price;
                        q.offer(new Pair(b, dist[b]));
                    }
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1));
        System.out.println(findCheapestPrice2(4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1));
//        [[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]]
        System.out.println(findCheapestPrice(5, new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}}, 2, 1, 1));
        System.out.println(findCheapestPrice2(5, new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}}, 2, 1, 1));
    }
}
