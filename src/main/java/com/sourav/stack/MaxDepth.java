package com.sourav.stack;

import java.util.Stack;

//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
public class MaxDepth {
    public int maxDepth(String s) {
        int res= 0;
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '('){
                stack.push(c);
                res= Math.max(res, stack.size());
            } else if (c == ')'){
                stack.pop();
            }
        }
        return res;
    }
}
