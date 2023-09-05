package com.sourav.leetcode.SlidingWindow;

public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int sum =0;
        for (int j : gain) {
            sum += j;
            maxAltitude = Math.max(maxAltitude, sum);
        }
        return maxAltitude;
    }
}
