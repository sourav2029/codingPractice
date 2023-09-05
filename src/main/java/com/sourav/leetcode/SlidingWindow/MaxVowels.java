package com.sourav.leetcode.SlidingWindow;

import javax.xml.stream.events.Characters;

public class MaxVowels {
    public static int maxVowels(String s, int k) {
        int maxVowel = 0, i = 0;
        while (i < k) {
            maxVowel += isVowel(s.charAt(i));
            i++;
        }
        int currVowel = maxVowel;
        while (i < s.length()) {
            int currIndex = isVowel(s.charAt(i));
            int lastIndex = isVowel(s.charAt(i - k));
            currVowel += (currIndex - lastIndex);
            maxVowel = Math.max(currVowel, maxVowel);
            i++;
        }
        return maxVowel;
    }

    public static int isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("aeiou", 3));
        System.out.println(maxVowels("aeiou", 1));
        System.out.println(maxVowels("abciiidef", 5));
    }

}
