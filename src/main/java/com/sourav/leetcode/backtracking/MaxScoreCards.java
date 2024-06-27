package com.sourav.leetcode.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxScoreCards {

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char c : letters) {
            freq[c - 'a']++;
        }
        return findScore(words, 0, freq, score);
    }

    public static int findScore(String[] words, int index, int[] freq, int[] score) {
        if (index == words.length) {
            return 0;
        }
        String word = words[index];
        int scoreIfWordNotIncluded = findScore(words, index + 1, freq, score);
        int scoreIfWordIncluded = 0;
        int scoreOfCurrentWord = 0;
        boolean canCurrentWordBeIncluded = true;

        for (char c : word.toCharArray()) {
            int ind = c - 'a';
            if (freq[ind] == 0) {
                canCurrentWordBeIncluded = false;
            }
            freq[ind]--;
            scoreOfCurrentWord += score[ind];
        }
        if (canCurrentWordBeIncluded) {
            scoreIfWordIncluded = scoreOfCurrentWord + findScore(words, index + 1, freq, score);
        }
        for (char c : word.toCharArray()) {
            int ind = c - 'a';
            freq[ind]++;
        }
        return Math.max(scoreIfWordNotIncluded, scoreIfWordIncluded);
    }

    public static void main(String[] args) {
        System.out.println(maxScoreWords(new String[]{"dog", "cat", "dad", "good"}, new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
