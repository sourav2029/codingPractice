package com.sourav.leetcode.SlidingWindow;

public class LongestSubarray {
    public static int longestSubarray(int[] nums) {
        int max = 0;
        int start = 0, zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            max = Math.max(max, i-start);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1}));
    }
}
