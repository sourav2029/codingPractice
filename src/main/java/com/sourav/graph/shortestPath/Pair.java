package com.sourav.graph.shortestPath;

public class Pair implements Comparable<Pair> {
    int first;
    int second;
    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
    public int compareTo(Pair o) {
        return Integer.compare(this.first, o.first);
    }
}
