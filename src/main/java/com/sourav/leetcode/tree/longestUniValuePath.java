package com.sourav.leetcode.tree;

public class longestUniValuePath {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        fun(root);
        return res;
    }

    public int fun(TreeNode root){
        if (root == null){
            return 0;
        }
        int ans = 0;
        int currMax = 0;
        if(root.left != null){
            int left = fun(root.left);
            if(root.val == root.left.val){
                ans+= left+1;
                currMax = Math.max(currMax, left+1);
            }
        }
        if(root.right != null){
            int right = fun(root.right);
            if(root.val == root.right.val){
                ans+= right+1;
                currMax =Math.max(currMax, right+1);
            }
        }
        res = Math.max(res, ans);
        return currMax;
    }
}

