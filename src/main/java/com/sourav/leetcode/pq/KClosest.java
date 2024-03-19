package com.sourav.arrayandstring;

import java.util.Collections;
import java.util.PriorityQueue;


public  class Pair{
    int x, y;
    long distance;

}

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Long, Integer>
        for (int i = 0; i < points.length; i++) {
            long distance = (long) points[i][0] * points[i][0] + (long) points[i][1]  * points[i][1];

        }
    }
}
