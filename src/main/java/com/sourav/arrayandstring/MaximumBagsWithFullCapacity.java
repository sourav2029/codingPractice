package com.sourav.arrayandstring;

import java.util.Arrays;

public class MaximumBagsWithFullCapacity {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] remainingCapacity = new int[n];
        for (int i = 0; i < n; i++) {
            remainingCapacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remainingCapacity);
        int count = 0;
        while (additionalRocks > 0 && count < n) {
            if (remainingCapacity[count] > 0) {
                if (remainingCapacity[count] > additionalRocks) {
                    return count;
                }
                additionalRocks -= remainingCapacity[count];
                count++;
            } else {
                count++;
            }
        }
        return count;
    }
}
