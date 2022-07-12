package com.sourav.trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {
    private TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        for (String str : products){
            add(str);
        }
        List<List<String>> res= new ArrayList<>();

        for (int i=0; i<searchWord.length(); i++){
            String subStr = searchWord.substring(0,i+1);
            res.add(returnTop3Matches(subStr));
        }
        return res;

    }


    public static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }

        public TrieNode getChild(char ch){
            return children[ch-'a'];
        }
    }

    public void add(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            TrieNode child = curr.getChild(ch);
            if (child == null){
                curr.children[ch-'a'] = new TrieNode();
                curr = curr.getChild(ch);
            } else {
                curr = child;
            }
        }
        curr.isEnd = true;
    }

    public List<String> returnTop3Matches(String prefix){
        TrieNode curr = root;
        List<String> ans = new ArrayList<>();
        for (char ch: prefix.toCharArray()){
            TrieNode child = curr.getChild(ch);
            if (child == null){
                return ans;
            } else {
                curr = child;
            }
        }
        StringBuilder builder = new StringBuilder(prefix);
        append(curr, ans, builder);
        return ans;
    }


    public void append(TrieNode curr, List<String> ans, StringBuilder word){
        if (ans.size() >= 3){
            return;
        }
        if (curr.isEnd){
            ans.add(word.toString());
        }

        for (int i=0; i<curr.children.length;i++){
            if (curr.children[i] != null){
                char c = (char) ('a' + i);
                append(curr.children[i], ans, word.append(c));
                word.deleteCharAt(word.length()-1);
            }
        }
    }
}
