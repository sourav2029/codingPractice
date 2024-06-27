package com.sourav.leetcode.backtracking;

import java.util.Arrays;

public class PalindromePartioning4 {
    static int[][] dp;
    static boolean[][] isP;

    public static boolean checkPartitioning(String s) {
        precomputeSubArrayPalindome(s);
        int n = s.length();
        dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return isNumberOfCutsPossible(s, 0, 3) == 1;
    }

    public static int isNumberOfCutsPossible(String s, int index, int cuts) {
        if (index >= s.length()) {
            return cuts == 0 ? 1 : 2;
        }
        if (cuts < 0) {
            return 2;
        }
        if (dp[index][cuts] != -1) {
            return dp[index][cuts];
        }
        for (int end = index; end < s.length(); end++) {
            if (isPalindrome(index, end)) {
                if (isNumberOfCutsPossible(s, end + 1, cuts - 1) == 1) {
                    dp[index][cuts] = 1;
                    return dp[index][cuts];
                }
            }
        }
        dp[index][cuts] = 2;
        return dp[index][cuts];
    }

    public static boolean isPalindrome(int start, int end) {
        return isP[start][end];
    }

    public static void precomputeSubArrayPalindome(String s) {
        int n = s.length();
        isP = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j || (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isP[j + 1][i - 1]))) {
                    isP[j][i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(checkPartitioning("abcbdd"));
    }
}
