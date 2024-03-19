package com.sourav.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/diameter-of-n-ary-tree/description/
public class DiameterNAry {
    int ans = 0;

    public int diameter(Node root) {
        ans = 0;
        diameterHelper(root);
        return ans;
    }

    public int diameterHelper(Node root) {
        if (root == null) {
            return 0;
        }
        int longest = 0;
        int secondLongest = 0;
        for (Node child : root.children) {
            int curr = diameterHelper(child);
            if (curr > longest) {
                secondLongest = longest;
                longest = curr;
            } else if (curr > secondLongest) {
                secondLongest = curr;
            }
        }
        ans = Math.max(ans, longest + secondLongest);
        return longest + 1;
    }
}
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
