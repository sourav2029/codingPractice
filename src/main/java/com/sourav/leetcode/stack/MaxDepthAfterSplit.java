package com.sourav.leetcode.stack;

import java.util.Arrays;

public class MaxDepthAfterSplit {
    public static int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                ans[i] = depth % 2; // Assign group based on current depth parity
            } else {
                ans[i] = depth % 2;
                depth--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxDepthAfterSplit("(()())")));
        System.out.println(Arrays.toString(maxDepthAfterSplit("(())")));
        System.out.println(Arrays.toString(maxDepthAfterSplit("(())")));
        System.out.println(Arrays.toString(maxDepthAfterSplit("()")));
    }
}
