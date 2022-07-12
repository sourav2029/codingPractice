package com.sourav.stack;

import java.util.Stack;

public class minRemoveToMakeValid {

    class Pair {
        char ch;
        int ind;

        Pair(int ind, char ch) {
            this.ch = ch;
            this.ind = ind;
        }
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Pair> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(new Pair(ans.length(), ch));
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    Pair p = stack.pop();
                    ans.insert(p.ind, p.ch);
                    ans.append(ch);
                }
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
