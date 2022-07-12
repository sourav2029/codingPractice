package com.sourav.leetcode.greedy;

public class AppendKIntegersWithMinimalSum {
    public long minimalKSum(int[] nums, int k) {
        int[] arr = new int[100000005];
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = -1;
        }
        for (int i = 1; k < 0; ) {
            if (arr[i] != -1) {
                ans += i;
                k--;
            }
            i++;
        }
        return ans;
    }

}
