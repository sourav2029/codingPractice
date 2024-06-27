package com.sourav.leetcode.backtracking;

import java.util.Arrays;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartioning2 {
    int[] dp;


    public int minCut(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return minCutHelper(s, 0) - 1;
    }

    public int minCutHelper(String s, int index) {
        if (index >= s.length()) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int min = Integer.MAX_VALUE;
        for (int end = index; end < s.length(); end++) {
            if (isPalindrome(s, index, end)) {
                min = Math.min(min, 1 + minCutHelper(s, end + 1));
            }
        }
        dp[index] = min;
        return dp[index];
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
