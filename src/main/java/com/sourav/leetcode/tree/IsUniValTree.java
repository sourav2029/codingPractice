package com.sourav.leetcode.tree;

public class IsUniValTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftTreeUniValTree = true, isRightTreeUniValTree = true;

        if (root.left != null) {
            isLeftTreeUniValTree = isUnivalTree(root.left) && (root.val == root.left.val);
        }
        if(root.right != null){
            isRightTreeUniValTree = isUnivalTree(root.right) && (root.val == root.right.val);
        }
       return isLeftTreeUniValTree && isRightTreeUniValTree;
    }
}
