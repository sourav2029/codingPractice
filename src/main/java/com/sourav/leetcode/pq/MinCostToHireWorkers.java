package com.sourav.leetcode.pq;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireWorkers {


    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        PriorityQueue<Double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a ->  a[0]));
        // min priority queue by default
        for (int i = 0; i < n; i++) {
            double ratio = wage[i] * 1.0 / quality[i];
            pq.offer(new Double[]{ratio, quality[i] * 1.0});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        Double[] maxEntry = pq.poll();
        double maxRatio = maxEntry[0];
        double ans = maxRatio * maxEntry[1];

        while (!pq.isEmpty()) {
            maxEntry = pq.poll();
            ans += maxRatio * maxEntry[1];
        }
        return ans;
    }

    public static void main(String[] args) {
                int numberOfOnes = 8; // Number of bits to set to 1
                int result = (1 << numberOfOnes) - 1;
                System.out.println("Number with all 1s: " + Integer.toBinaryString(result));


        System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
    }
}
