package com.sourav.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<>(), s);
        return res;
    }

    public static void dfs(int start, List<List<String>> res, List<String> curr, String s) {
        if (start >= s.length())
            res.add(new ArrayList<>(curr));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                dfs(end + 1, res, curr, s);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;

    }

    public static void main(String[] args) {
//        System.out.println(partition("aabaa"));
        System.out.println(partition(""));
        System.out.println(partition("a"));
    }
}
