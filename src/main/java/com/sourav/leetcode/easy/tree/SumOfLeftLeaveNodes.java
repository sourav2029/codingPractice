package com.sourav.leetcode.easy.tree;

//https://leetcode.com/problems/sum-of-left-leaves
public class SumOfLeftLeaveNodes {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode root, boolean isLeftChild){
        if (root == null){
            return 0;
        }

        if(root.left == null && root.right ==null && isLeftChild){
            return root.val;
        }
        int ans = 0;
        ans += dfs(root.left, true);
        ans += dfs(root.right, false);
        return ans;
    }
}
