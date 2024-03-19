package com.sourav.leetcode.easy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if (sum < 0) {
            return -1;
        }
        sum = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < 0) {
                ans = -1;
                sum = 0;
            } else if (ans == -1) {
                ans = i;
            }
        }
        return ans;
    }
}

