package com.sourav.leetcode.tree;

public class DiameterOfABinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        height(root);
        return ans;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        ans = Math.max(left + right, ans);
        return 1 + Math.max(left, right);
    }
}
