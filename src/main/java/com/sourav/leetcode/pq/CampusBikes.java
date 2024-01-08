package com.sourav.leetcode.pq;

import java.util.*;
//https://leetcode.com/problems/campus-bikes/description/

public class CampusBikes {


    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<WorkerBikePair> allPairs = new ArrayList<>();

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = manhattanDistance(workers[i], bikes[j]);
                allPairs.add(new WorkerBikePair(dist, i, j));
            }
        }

        Collections.sort(allPairs);
        boolean[] bikeStatus = new boolean[bikes.length];
        int[] workerStatus = new int[workers.length];
        Arrays.fill(workerStatus, -1);
        int pairCount = 0;

        for (final WorkerBikePair pair : allPairs) {
            int worker = pair.workerIdx;
            int bike = pair.bikeIdx;
            if (workerStatus[worker] == -1 && !bikeStatus[bike]) {
                bikeStatus[bike] = true;
                workerStatus[worker] = bike;
                pairCount++;

                if (pairCount == workers.length) {
                    return workerStatus;
                }
            }
        }
        return workerStatus;
    }

    public int manhattanDistance(int[] p0, int[] p1) {
        return Math.abs(p0[0] - p1[0]) + Math.abs(p0[1] - p1[1]);
    }


    public static void main(String[] args) {

    }

}
