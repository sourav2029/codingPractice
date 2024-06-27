package com.sourav.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList<>();
        traverse(root1, leafValues1);
        List<Integer> leafValues2 = new ArrayList<>();
        traverse(root2, leafValues2);
        return isEqual(leafValues1, leafValues2);
    }

    private boolean isEqual(List<Integer> leafValues1, List<Integer> leafValues2) {
        int n1 = leafValues1.size();
        int n2 = leafValues2.size();

        if (n1 != n2) {
            return false;
        }
        for (int i = 0; i < n1; i++) {
            if (leafValues1.get(i) != leafValues2.get(i)) {
                return false;
            }
        }
        return true;
    }


    public void traverse(TreeNode root, List<Integer> leafValues) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafValues.add(root.val);
        }
        traverse(root.left, leafValues);
        traverse(root.right, leafValues);
    }
}
