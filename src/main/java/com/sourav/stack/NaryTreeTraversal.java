package com.sourav.stack;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeTraversal {

    static class Node {
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

    List<Integer> ans;

    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        return ans;

    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(root.children.get(i));
        }
        ans.add(root.val);
        System.out.println(ans);
    }


}
