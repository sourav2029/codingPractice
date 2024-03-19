package com.sourav.leetcode.pq;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    int x, y;
    long distance;

    public Point(int x, int y, long distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }


    @Override
    public int compareTo(Point o) {
        return Long.compare(distance, o.distance);
    }
}
