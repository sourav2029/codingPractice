package com.sourav.leetcode.string;

public class ReversePrefix {
    public static String reversePrefix(String word, char ch) {
        int first = word.indexOf(ch);
        if (first == -1) {
            return word;
        }
        StringBuilder builder = new StringBuilder(word.substring(0, first + 1));
        builder.reverse().append(word.substring(first + 1));
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("daddjdwddwed", 'w'));
    }
}
