package com.sourav.trie;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    private TrieNode root;

    public static class TrieNode {
        char data;
        boolean isEnd;
        int count;
        Map<Character, TrieNode> children;


        public TrieNode(char c) {
            this.data = c;
            count = 0;
            isEnd = false;
            children = new HashMap<>();
        }

        public TrieNode getChild(char c) {
            if (children != null) {
                TrieNode child = children.get(c);
                return child;
            }
            return null;

        }
    }

    public WordDictionary() {
        root = new TrieNode(' ');
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = curr.getChild(ch);
            if (child == null) {
                TrieNode node = new TrieNode(ch);
                curr.children.put(ch, node);
                curr = curr.getChild(ch);
            } else {
                curr = child;
            }
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }


    public boolean search(String word, TrieNode node) {
        if (word.length() == 0) {
            return node.isEnd;
        }
        TrieNode curr = node;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child : curr.children.values()) {
                    if (search(word.substring(i + 1), child)) {
                        return true;
                    }
                    return false;
                }
            } else {
                TrieNode child = curr.getChild(ch);
                if (child == null) {
                    return false;
                }
                return search(word.substring(i + 1), child);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
//        System.out.println(wordDictionary.search(".")); // return true
//        System.out.println(wordDictionary.search("a")); // return true
//        System.out.println(wordDictionary.search("aa")); // return false
        System.out.println(wordDictionary.search("a.")); // return false
        System.out.println(wordDictionary.search(".a")); // return true
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
