package com.sourav.arrayandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {

    public class Pair implements Comparable<Pair> {
        int val;
        int ind;

        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }

        public int compareTo(Pair o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int st = 0;
        int end = n - 1;
        while (st < end) {
            int sum = pairs[st].val + pairs[end].val;
            if (sum == target) {
                return new int[]{pairs[st].ind, pairs[end].ind};
            }
            if (sum > target) {
                end--;
            }
            if (sum < target) {
                st++;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumV2(int[] nums, int target) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int st = 0;
        int end = n - 1;
        while (st < end) {
            int sum = pairs[st].val + pairs[end].val;
            if (sum == target) {
                return new int[]{pairs[st].ind, pairs[end].ind};
            }
            if (sum > target) {
                end--;
            }
            if (sum < target) {
                st++;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
