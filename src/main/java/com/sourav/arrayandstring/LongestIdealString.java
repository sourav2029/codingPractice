package com.sourav.arrayandstring;

import java.util.Arrays;

public class LongestIdealString {
    public static int longestIdealString(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) <= k) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            } else {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestIdealString("jxhwaysa", 14));
    }
}
