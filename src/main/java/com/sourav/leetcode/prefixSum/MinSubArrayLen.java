package com.sourav.leetcode.prefixSum;

import java.util.Map;
import java.util.TreeMap;

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Map.Entry<Integer, Integer> entry = map.floorEntry(sum - target);
            if (entry != null) {
                ans = Math.min(ans, i - entry.getValue());
            }
            map.put(sum, i);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int st = 0;
        int end = 0;
        while (end < nums.length) {
            sum += nums[end];
            end++;
            if (sum >= target) {
                while (st < end && sum - nums[st] >= target ) {
                    sum-= nums[st];
                    st++;
                }
                ans = Math.min(ans, end - st);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen2(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen2(11, new int[]{1, 4, 4}));



        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }
}
