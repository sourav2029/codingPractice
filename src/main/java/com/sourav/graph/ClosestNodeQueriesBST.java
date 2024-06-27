package com.sourav.graph;

import com.sourav.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ClosestNodeQueriesBST {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, set);
        for (Integer query : queries) {
            List<Integer> list = new ArrayList<>();
            Integer floor = set.floor(query);
            if (floor == null) {
                list.add(-1);
            } else {
                list.add(floor);
            }
            Integer ceiling = set.ceiling(query);
            if (ceiling == null) {
                list.add(-1);
            } else {
                list.add(ceiling);
            }
            ans.add(list);
        }
        return ans;
    }

    public void dfs(TreeNode root, Set<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}


// Time complexity : o(n) + nlog(n) + mlog(n)
// n - number of nodes
// m - number of queries

//Space complexity : o(n)
