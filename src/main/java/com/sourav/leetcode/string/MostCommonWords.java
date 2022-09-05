package com.sourav;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWords {
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ");
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> bannedWords = new HashMap<>();

        for (int i = 0; i < banned.length; i++) {
            bannedWords.put(banned[i], 1);
        }
        int ans = 0;
        String res = "";
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (bannedWords.containsKey(words[i])) {
                continue;
            }
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
                if (map.get(words[i]) > ans) {
                    ans = map.get(words[i]);
                    res = words[i];
                }
            } else {
                map.put(words[i], 1);
                if (1 > ans) {
                    ans = 1;
                    res = words[i];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String[] banned = {"a"};
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", banned
        ));
    }
}
