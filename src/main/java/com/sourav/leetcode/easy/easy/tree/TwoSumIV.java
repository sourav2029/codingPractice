package com.sourav.leetcode.easy.easy.tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

////https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for(int i=0, j=list.size()-1; i<j; ){
            int sum = list.get(i) + list.get(j);
            if (sum == k){
                return true;
            } else if (sum < k){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs2(root, k, set);
    }


    public boolean dfs2(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (dfs2(root.left, k, set)) {
            return true;
        }

        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs2(root.right, k, set);
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
