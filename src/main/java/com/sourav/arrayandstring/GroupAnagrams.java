package com.sourav.arrayandstring;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String s : strs) {
             String temp = getKey(s);
            if (anagramsMap.containsKey(temp)) {
                anagramsMap.get(temp).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                anagramsMap.put(temp, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        ans.addAll(anagramsMap.values());
        return ans;
    }

    public String getKey(String s) {
        char[] arr = new char[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        String res = String.valueOf(arr);
        return res;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
