package com.sourav.leetcode.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeStringGood {
    public static String makeGood(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty()) {
                int top = deque.peekLast();
                if (Math.abs(c - top) == 32) {
                    deque.pollLast();
                } else {
                    deque.offerLast(c);
                }
            } else {
                deque.offerLast(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : deque) {
            builder.append(ch);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("dcabBACD"));
    }
}
