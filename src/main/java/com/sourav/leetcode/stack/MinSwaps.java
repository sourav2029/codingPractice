package com.sourav.leetcode.stack;

//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
public class MinSwaps {
    public int minSwaps(String s) {
        int open = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                open++;
            } else {
                if (open == 0) {
                    ans++;
                } else {
                    open--;
                }
            }
        }
        return (ans + 1) / 2;
    }
}
