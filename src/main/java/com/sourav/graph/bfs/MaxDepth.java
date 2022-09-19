package com.sourav.graph.bfs;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int res= 0;
        if (root == null){
            return res;
        }
        res = Math.max(maxDepth(root.left), maxDepth(root.right));
        return res+1;
    }
}
