package com.sourav.arrayandstring;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
public class MaxSubArrayLength {
    public static int maxSubarrayLength(int[] nums, int k) {
        int ans = 0, st = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            int currFreq = map.get(nums[end]);
            maxFreq = Math.max(maxFreq, currFreq);
            if (maxFreq > k) {
                int toRemove = nums[end];
                while (st <= end && nums[st] != toRemove) {
                    map.put(nums[st], map.get(nums[st]) - 1);
                    st++;
                }
                map.put(nums[st], map.get(nums[st]) - 1);
                st++;
                maxFreq--;
            }
            ans = Math.max(ans, end - st + 1);
        }
        return st == 0 ? nums.length : ans;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubarrayLength(new int[]));
    }
}
