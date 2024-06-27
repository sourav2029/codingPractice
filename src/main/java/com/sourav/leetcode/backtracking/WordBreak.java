package com.sourav.leetcode.backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    Map<String, Boolean> wordMap;
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordMap = new HashMap<>();
        for (String word : wordDict) {
            wordMap.put(word, true);
        }
        int len = s.length();
        dp = new Boolean[len];
        return wordBreakHelper(s, 0);
    }

    public boolean wordBreakHelper(String s, int index) {
        if (index >= s.length()) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        boolean ans = false;
        for (int i = index; i < s.length(); i++) {
            String currWord = s.substring(index, i + 1);
            if (wordMap.containsKey(currWord)) {
                ans |= wordBreakHelper(s, i + 1);
            }
        }
        dp[index] = ans;
        return dp[index];
    }
}
