package com.sourav.stack;

import java.util.Stack;

public class RemoveOuterParantheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    ans.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if(!stack.isEmpty()){
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
//        "(()())(())"
//"(()())(())(()(()))"
//"()()"
//"()"
//"((()))"
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
