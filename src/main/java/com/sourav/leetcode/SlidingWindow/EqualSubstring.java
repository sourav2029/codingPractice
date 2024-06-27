package com.sourav.leetcode.SlidingWindow;

public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int len = s.length();
        int currCost = 0;
        int maxLength = 0;
        for (int end = 0; end < len; end++) {
            currCost += Math.abs(s.charAt(end) - t.charAt(end));
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
