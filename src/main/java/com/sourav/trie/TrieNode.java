package com.sourav.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    char data;
    int count;
    boolean isEnd;
    Map<Character, TrieNode> children;

    public TrieNode(char c) {
        this.data = c;
        count = 0;
        isEnd = false;
        children = new HashMap<>();
    }

    public TrieNode getChild(char c) {
        if (children != null) {
            if (children.containsKey(c)) {
                return children.get(c);
            }
        }
        return null;
    }
}
