package com.sourav.trieWithArray;

public class TrieNode1 {
    boolean isEnd;
    TrieNode1[] children;

    public TrieNode1() {
        isEnd = false;
        children = new TrieNode1[26];
    }

    public TrieNode1 getChild(char c){
        return children[c-'a'];
    }
}
