package com.sourav.leetcode.string;

public class MakeGood {
    public static String makeGood(String s) {
        while (true) {
            int len = s.length();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len;) {
                if (i + 1 < len && s.charAt(i) - 'a' == s.charAt(i + 1) - 'A') {
                    i += 2;
                } else {
                    builder.append(s.charAt(i++));
                }
            }
            if (builder.length() == s.length()) {
                return builder.toString();
            }
            s = builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(makeGood("Pp"));
    }
}
