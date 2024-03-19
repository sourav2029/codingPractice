package com.sourav.leetcode.prefixSum;

import java.util.ArrayList;
import java.util.List;

public class GoodIndices {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                prefixSum[i] += prefixSum[i - 1];
            } else {
                prefixSum[i] = 1;
            }
        }
        int[] siffixSum = new int[n];
        siffixSum[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                siffixSum[i] += siffixSum[i - 1];
            } else {
                siffixSum[i] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (prefixSum[i] == k && siffixSum[i] == k) {
                ans.add(i);
            }
        }
        return ans;
    }
}
