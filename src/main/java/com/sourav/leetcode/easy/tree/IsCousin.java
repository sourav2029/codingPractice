package com.sourav.leetcode.easy.tree;

import java.util.*;

public class IsCousin {
    public static class Pair {
        TreeNode node;
        int level;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, root));
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode currNode = p.node;
            int currLevel = p.level;
            map.put(currNode.val, currLevel);
            if (currNode.left != null){
                parent.put(currNode.left.val, currNode.val);
                queue.offer(new Pair(currLevel + 1, currNode.left));
            }
            if (currNode.right != null){
                parent.put(currNode.right.val, currNode.val);
                queue.offer(new Pair(currLevel + 1, currNode.right));
            }
        }

        return map.get(x).equals(map.get(y)) && !parent.get(x).equals(parent.get(y));
    }
}
