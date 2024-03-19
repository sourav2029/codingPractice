package com.sourav.leetcode.easy;

public class StringCompression {
    public static int compress(char[] chars) {
        int len = chars.length;
        int res = 0;
        int i = 0;
        while (i < len) {
            int groupLength = 1;
            chars[res++] = chars[i];
            while (i + groupLength < len && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i = i + groupLength;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] in = new char[]{'a'};
        int len = compress(in);
        for (int i = 0; i < len; i++) {
            System.out.print(in[i]);
        }
    }
}
