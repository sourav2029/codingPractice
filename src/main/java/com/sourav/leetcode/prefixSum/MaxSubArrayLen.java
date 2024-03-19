package com.sourav.leetcode.prefixSum;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
public class MaxSubArrayLen {
    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[]{1,1,0}, 1));
        System.out.println(maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));
        System.out.println(maxSubArrayLen(new int[]{-2,-1,2,1}, 1));
        System.out.println(maxSubArrayLen(new int[]{1,1,0}, 1));

    }
}
