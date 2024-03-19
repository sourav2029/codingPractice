package com.sourav.leetcode.easy.tree;

public class SufficientSubset {

    public class Pair {
        TreeNode node;
        boolean wasDeleted;

        public Pair(TreeNode node, boolean wasDeleted) {
            this.node = node;
            this.wasDeleted = wasDeleted;
        }

    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        Pair p = dfs(root, 0, limit);
        return p.node;
    }

    public Pair dfs(TreeNode node, int sum, int limit) {
        if (node == null) {
            return new Pair(node, false);
        }
        sum += node.val;
        Pair left = dfs(node.left, sum, limit);
        Pair right = dfs(node.right, sum, limit);
        node.left = left.node;
        node.right = right.node;
        if (node.left == null && node.right == null) {
            if (left.wasDeleted && right.wasDeleted) {
                return new Pair(null, true);
            }
        }
        return new Pair(node, false);

    }
}
