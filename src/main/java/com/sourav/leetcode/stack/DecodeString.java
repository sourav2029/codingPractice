package com.sourav.leetcode.stack;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        int num = 0;
        Stack<StringBuilder> ss = new Stack<>();
        Stack<Integer> is = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';
            } else if (ch == '[') {
                ss.push(builder);
                builder = new StringBuilder();
                is.push(num);
                num = 0;
            } else if (ch == ']') {
                StringBuilder temp = builder;
                builder = ss.pop();
                int count = is.pop();
                while (count-- > 0) {
                    builder.append(temp);
                }
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]200[bc]"));
    }
}
