package com.sourav.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    //    Same word can be reused multiple times
    public static boolean wordBreakBruteForce(String s, List<String> wordDict, Map<String, Boolean> isPresent) {
        if (s.length() == 0)
            return true;
        if (isPresent.containsKey(s))
            return isPresent.get(s);
        for (int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);
            System.out.println(current);
            if (wordDict.contains(current)) {
                String remaining = s.substring(i);
                if (wordBreakBruteForce(remaining, wordDict, isPresent))
                    return true;
                else
                    isPresent.put(remaining, false);
            } else {
                isPresent.put(current, false);
            }
        }
        return false;
    }

    // Same word cannot be reused multiple times
    public static boolean wordBreakBruteForce2(String s, List<String> wordDict) {
        if (s.length() == 0)
            return true;
        for (int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);
            System.out.println(current);
            if (wordDict.contains(current)) {
                wordDict.remove(current);
                if (wordBreakBruteForce2(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreakWithMap(String s, Map<String, Boolean> isPresent) {
        if (s.length() == 0)
            return true;
        if (isPresent.containsKey(s))
            return isPresent.get(s);
        System.out.println(s);
        for (int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);
            if (isPresent.containsKey(current) && isPresent.get(current) == true) {
                String remaining = s.substring(i);
                if (wordBreakWithMap(remaining, isPresent))
                    return true;
                else
                    isPresent.put(remaining, false);
            } else {
                isPresent.put(current, false);
            }
        }
        return false;
    }

    /*public static boolean wordBreakDP(String s, List<String> wordDict) {
        Boolean dp[] = new Boolean[s.length() + 1];
        dp[0] = true;

    }*/


//    public static boolean wordBreakHelper(String s, List<String> wordDict, int index) {
//
//        for (int i = 0; i < s.length(); i++) {
//
//        }
//    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        Map<String, Boolean> isPresent = new HashMap<>();
        wordDict.add("word");
        wordDict.add("w");
        wordDict.add("wo");
//        System.out.println(wordBreakBruteForce("wordword", wordDict, isPresent));
        System.out.println(wordBreakWithMap("wordword", isPresent));
    }
}
