package com.sourav.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//https://leetcode.com/problems/minimum-distance-between-bst-nodes/submissions/
public class MinDiffInBST {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<list.size()-1; i++){
            ans = Math.min(ans, Math.abs(list.get(i)- list.get(i+1)));
        }
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
