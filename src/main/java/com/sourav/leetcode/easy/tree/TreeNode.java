package com.sourav.leetcode.easy.easy.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
