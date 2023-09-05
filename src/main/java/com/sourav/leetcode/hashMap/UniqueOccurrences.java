package com.sourav.leetcode.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int elem : arr) {
            if (count.containsKey(elem)) {
                count.put(elem, count.get(elem) + 1);
            } else {
                count.put(elem, 1);
            }
        }
        Set<Integer> unique = new HashSet<>();
        for (int key : count.values()) {
            if (unique.contains(key)) {
                return false;
            }
            unique.add(key);
        }
        return true;

    }
}
