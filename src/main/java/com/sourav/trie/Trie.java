package com.sourav.trie;

import java.util.HashMap;
import java.util.Map;

class Trie {

    public static class TrieNode {
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

    private TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        if(search(word)){
            return;
        }

        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            TrieNode child = curr.getChild(ch);
            if(child==null){
                curr.children.put(ch, new TrieNode(ch));
                curr = curr.getChild(ch);
            } else {
                curr = child;
            }
            curr.count++;
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child == null)
                return false;
            else
                current = child;
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()){
            TrieNode  child = curr.getChild(ch);
            if(child == null){
                return false;
            } else {
                curr = child;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
