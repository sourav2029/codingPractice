package com.sourav.leetcode.easy;

public class GCDString {
    public static String gcdOfStrings(String str1, String str2) {
        String min, max;
        if (str1.length() < str2.length()) {
            min = str1;
            max = str2;
        } else {
            min = str2;
            max = str1;
        }
        int minLength = min.length();
        for (int i = 0; i < minLength; i++) {
            String curr = min.substring(0, minLength - i);
            if (isDivisible(curr, max) && isDivisible(curr, min)) {
                return curr;
            }
        }
        return "";
    }

    public static String gcdOfStrings2(String str1, String str2) {
        if (!(str2 + str1).equals(str1 + str2)) {
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }


    public static boolean isDivisible(String t, String s) {
        if (s.length() % t.length() != 0) {
            return false;
        }
        int count = s.length() / t.length();
        StringBuilder newt = new StringBuilder();
        for (int i = 0; i < count; i++) {
            newt.append(t);
        }
        String newString = newt.toString();
        return s.equals(newString);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
    }
}
