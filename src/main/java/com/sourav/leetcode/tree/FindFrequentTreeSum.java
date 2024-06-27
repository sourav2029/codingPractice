//package com.sourav.leetcode.easy.tree;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class FindFrequentTreeSum {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     * int val;
//     * TreeNode left;
//     * TreeNode right;
//     * TreeNode() {}
//     * TreeNode(int val) { this.val = val; }
//     * TreeNode(int val, TreeNode left, TreeNode right) {
//     * this.val = val;
//     * this.left = left;
//     * this.right = right;
//     * }
//     * }
//     */
//    Map<Integer, Integer> freq;
//
//    public int[] findFrequentTreeSum(TreeNode root) {
//        freq = new HashMap<>();
//        dfs(root);
//        List<Integer> ans = new ArrayList<>();
//        int maxFreq = -1;
//        int maxFreqCount = 0;
//        for (int entry : freq.values()) {
//            if (entry > maxFreq) {
//                maxFreq
//            }
//        }
//    }
//
//    public int dfs(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        int left = dfs(node.left);
//        int right = dfs(node.right);
//        int subTreeSum = left + right + node.val;
//        freq.put(subTreeSum, freq.getOrDefault(subTreeSum, 0) + 1);
//        return subTreeSum;
//    }
//
//
//    public int max(List<Intge)
//}
