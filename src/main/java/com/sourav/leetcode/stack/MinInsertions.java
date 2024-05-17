package com.sourav.leetcode.stack;

public class MinInsertions {
    public static  int minInsertions(String s) {
        int open = 0;
        int counter = 0;
        int ans = 0;
        boolean hasStartedClosing = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (hasStartedClosing && open%2 != 0) {
                    ans ++;
                    hasStartedClosing = false;
                } else {
                    open += 2;
                    hasStartedClosing = false;
                }
            } else {
                if (open > 0) {
                    open--;
                    hasStartedClosing = true;
                } else {
                    counter++;
                    if (counter == 2) {
                        ans++;
                        counter = 0;
                    }
                }
            }
        }
        if (counter > 0) {
            ans += 2;
        }
        return ans + open;
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))"));
    }
}
