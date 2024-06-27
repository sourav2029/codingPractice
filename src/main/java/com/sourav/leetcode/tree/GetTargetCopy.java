package com.sourav.leetcode.tree;

//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class GetTargetCopy {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (target == original){
            return cloned;
        }
        if (original == null){
            return null;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null){
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}
