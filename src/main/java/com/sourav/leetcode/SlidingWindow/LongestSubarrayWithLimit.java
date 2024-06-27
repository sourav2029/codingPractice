package com.sourav.leetcode.SlidingWindow;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/?envType=daily-question&envId=2024-06-23
public class LongestSubarrayWithLimit {
    //    BruteForce
    public int longestSubarray1(int[] nums, int limit) {
        int ans = 0;
        for (int start = 0; start < nums.length; start++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int end = start; end < nums.length; end++) {
                min = Math.min(nums[end], min);
                max = Math.max(nums[end], max);
                if (max - min <= limit) {
                    ans = Math.max(ans, end - start + 1);
                }
            }

        }
        return ans;
    }

//    public int longestSubarray2(int[] nums, int limit) {
//        int ans = 0;
//        int start = 0;
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int end = 0; end < nums.length; end++) {
//            min = Math.min(min, nums[end]);
//            max = Math.max(max, nums[end]);
//            if (max - min <= limit) {
//                ans = Math.max(ans, end - start + 1);
//            }
//            while (max - min >= limit) {
//                if(nums[start] )
//            }
//
//        }
//        return ans;
//    }
}
