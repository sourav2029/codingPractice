package com.sourav.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryLevelOrderTraversal {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return ans;
        }
        ans = new ArrayList<>();
        bfs(root);
        return ans;
    }

    public static class Pair {
        int level;
        Node node;

        Pair(int level, Node _node) {
            this.node = _node;
            this.level = level;
        }
    }

    public void bfs(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, root));
        int prevLevel = 1;
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int currLevel = pair.level;
            res.add(pair.node.val);
            for (Node node : pair.node.children) {
                q.add(new Pair(currLevel + 1, node));
            }
            if (currLevel > prevLevel) {
                ans.add(res);
                res = new ArrayList<>();
                prevLevel = currLevel;
            }

        }
    }
}
