package com.sourav.leetcode.tree;

public class BSTtoGST {
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    public int helper(TreeNode node, int greaterSum) {
        if (node == null) {
            return 0;
        }
        if (node.right != null) {
            node.val += helper(node.right, greaterSum);
        } else {
            node.val += greaterSum;
        }

        if (node.left != null) {
            return helper(node.left, node.val);
        }
        return node.val;
    }
}
