package com.sourav.leetcode.easy.tree;

import java.util.*;

public class AmountOfTime {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        convert(root, 0, map);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        int minutes = 0;
        visited.add(start);
        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level > 0) {
                int curr = queue.poll();
                for (int num : map.get(curr)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                level--;
            }
            minutes++;
        }
        return minutes - 1;
    }

    public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> graph) {
        if (current == null) {
            return;
        }

        if (!graph.containsKey(current.val)) {
            graph.put(current.val, new HashSet<>());
        }
        Set<Integer> adjacentList = graph.get(current.val);
        if (parent != 0) {
            adjacentList.add(parent);
        }
        if (current.left != null) {
            adjacentList.add(current.left.val);
        }
        if (current.right != null) {
            adjacentList.add(current.right.val);
        }
        convert(current.left, current.val, graph);
        convert(current.right, current.val, graph);
    }
}
