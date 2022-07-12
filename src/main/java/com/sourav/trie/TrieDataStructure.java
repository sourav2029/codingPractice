package com.sourav.trie;

import java.util.Map;

public class TrieDataStructure {
    private TrieNode root;

    public TrieDataStructure() {
        root = new TrieNode(' ');
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
        return current.isEnd == true;
    }

    public void insert(String word) {
        if (search(word))
            return;

        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child == null) {
                current.children.put(ch, new TrieNode(ch));
                current = current.getChild(ch);
            } else {
                current = child;
            }
            current.count++;
        }
        current.isEnd = true;
    }

    public void remove(String word) {
        if (!search(word)) {
            System.out.println("Missing word in Trie: " + word);
            return;
        }

        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child.count == 1) {
                current.children.remove(child);
                return;
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }


    public static void printAllWordsInTrie(TrieNode node, String s) {
        TrieNode current = node;
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            if (entry.getValue().isEnd) {
                System.out.println(" " + s + entry.getKey());
            }
            printAllWordsInTrie(entry.getValue(), s + entry.getKey());
        }
    }

    public static void main(String[] args) {
        TrieDataStructure t = new TrieDataStructure();
        t.insert("dear");
        t.insert("deal");
        t.insert("do");
        t.insert("he");
        t.insert("hen");
        t.insert("heat");
        t.insert("sourav");
        t.insert("Prem");


        System.out.println("hen present in trie : " + t.search("hen"));
        System.out.println("hear present in trie : " + t.search("hear"));
        System.out.println("deal present in trie : " + t.search("deal"));
        System.out.println("========================");
        System.out.println("Printing all word present in trie : ");
        printAllWordsInTrie(t.root, "");
    }
}
