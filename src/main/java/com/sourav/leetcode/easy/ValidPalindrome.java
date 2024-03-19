package com.sourav.leetcode.easy;

import java.util.Locale;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                builder.append(s.charAt(i));
            }
        }
        String str = builder.toString().toLowerCase();
        System.out.println(str);
        int st = 0, end = str.length() - 1;
        while (st <= end) {
            if (str.charAt(st) != str.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}


