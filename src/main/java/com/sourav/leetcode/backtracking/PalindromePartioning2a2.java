package com.sourav.leetcode.backtracking;

public class PalindromePartioning2a2 {
    static Boolean[][] memo;
    static Integer[][] dp;
    public static int minCut(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        dp = new Integer[n][n];
        return helper(s, 0, n-1);
    }

    public static int helper(String s, int start, int end){
        if(start < 0 || end > s.length()-1){
            return 0;
        }

        if(start ==  end || isPalindrome(s, start, end)){
            return 0;
        }

        if(dp[start][end] != null){
            return dp[start][end];
        }

        int n = s.length();
        int ans = Integer.MAX_VALUE;
        for(int i= start; i<= end; i++){
            if(isPalindrome(s, start, i)){
                ans = Math.min(ans, 1+ helper(s, i+1, end));
            }
        }
        return dp[start][end] = ans;

    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        return memo[start][end] = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1);
    }


    public static void main(String[] args) {
        System.out.println(minCut("ababababababababababababcbabababababababababababa"));
        System.out.println(minCut("aabba"));

    }
}
