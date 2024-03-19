package com.sourav.graph;

import com.sourav.graph.bfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

    private int maxDepth;
    private int bottomLeftValue;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int leftMost = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    continue;
                }
                if (i == 0) {
                    leftMost = curr.val;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return leftMost;
    }

    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) {
            return -1;
        }
        bottomLeftValue = 0;
        dfs(root, 0);
        return bottomLeftValue;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeftValue = node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
