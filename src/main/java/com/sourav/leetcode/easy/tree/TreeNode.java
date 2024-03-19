package com.sourav.leetcode.easy.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(){
    }
    TreeNode(int value){
        val = value;
    }
    TreeNode(int value, TreeNode left, TreeNode right){
        this.val = value;
        this.left = left;
        this.right = right;
    }
}
