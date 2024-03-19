package com.sourav.leetcode.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosest {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            long distance = (long) points[i][0] * points[i][0] + (long) points[i][1] * points[i][1];
            Point p = new Point(points[i][0], points[i][1], distance);
            pq.add(p);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[2][2];
        points[0][0] = 1;
        points[0][1] = 3;
        points[1][0] = -2;
        points[1][1] = 2;
        int k = 1;
        int[][] res = new int[k][2];
        res = kClosest(points, k);
        for(int i=0; i<k; i++){
            System.out.println(res[i][0] + " "+ res[i][1]);
        }
    }
}
