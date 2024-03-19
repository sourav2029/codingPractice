package com.sourav.leetcode.string;

import java.util.Arrays;

public class CloseString {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        if (n1 != n2) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int wordBit1 = 0, wordBit2 = 0;
        for (int i = 0; i < n1; i++) {
            int t1 = word1.charAt(i) - 'a';
            int t2 = word2.charAt(i) - 'a';
            count1[t1]++;
            wordBit1 = wordBit1 | (1 << t1);
            count2[t2]++;
            wordBit2 = wordBit2 | (1 << t2);
        }

        if (wordBit1 != wordBit2) {
            return false;
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[1]) {
                return false;
            }
        }
        return true;
    }
}
