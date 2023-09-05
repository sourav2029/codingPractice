package com.sourav.leetcode.hashMap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len2 != len1) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < len2; i++) {
            count2[word2.charAt(i) - 'a']++;
            count1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((count2[i] > 0 && count1[i] == 0) || (count2[i] == 0 && count1[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for (int i = 0; i < 26; i++) {
            if (count2[i] != count1[i]) {
                return false;
            }
        }
        return true;
    }
}
