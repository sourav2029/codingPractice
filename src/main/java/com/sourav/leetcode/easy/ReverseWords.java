package com.sourav.leetcode.easy;

import io.jsonwebtoken.lang.Strings;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("   My   name    is SSQSJS(SW((W "));
    }
}
