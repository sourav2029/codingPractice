package com.sourav.stack;

import java.util.Stack;

public class SmallestSubsequence {
    public static String smallestSubsequence(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            while (!visited[ch-'a'] && !stack.isEmpty() && stack.peek() > ch && freq[stack.peek() - 'a'] > 0) {
                char top = stack.pop();
                visited[top - 'a'] = false;
            }
            if(!visited[ch-'a']){
                visited[ch - 'a'] = true;
                stack.push(ch);
            }
            freq[ch - 'a']--;
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(smallestSubsequence("cbaacabcaaccaacababa"));
    }
}
