package com.sourav.leetcode.pq;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/furthest-building-you-can-reach/description/
public class FurthestBuilding {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff < 0) {
                continue;
            }
            pq.add(diff);
            if (pq.size() <= ladders) {
                continue;
            }
            int minDiff = pq.remove();
            bricks -= minDiff;
            if (bricks < 0) {
                return i;
            }
        }
        return n - 1;
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
    }
}
