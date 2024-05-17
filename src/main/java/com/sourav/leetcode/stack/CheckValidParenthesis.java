package com.sourav.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckValidParenthesis {

    public static boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return checkValidStringHelper(0, 0, s, dp);
    }

    public static boolean checkValidStringHelper(int openCount, int index, String s, int[][] dp) {
        if (index == s.length()) {
            return openCount == 0;
        }

        if (dp[index][openCount] != -1) {
            return dp[index][openCount] == 1;
        }
        boolean isValid = false;
        if (s.charAt(index) == '*') {
            isValid |= checkValidStringHelper(openCount + 1, index + 1, s, dp);
            if (openCount > 0) {
                isValid |= checkValidStringHelper(openCount - 1, index + 1, s, dp);
            }
            isValid |= checkValidStringHelper(openCount, index + 1, s, dp);
        } else if (s.charAt(index) == '(') {
            isValid |= checkValidStringHelper(openCount + 1, index + 1, s, dp);
        } else {
            if (openCount > 0) {
                isValid |= checkValidStringHelper(openCount - 1, index + 1, s, dp);
            }
        }
        dp[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }


    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
