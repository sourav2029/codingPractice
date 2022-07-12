package com.sourav.leetcode.greedy;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class AdvantageShuffle {
    static TreeMap<Integer, Integer> multiSet = new TreeMap<>();

    static void add(int x) {
        if (multiSet.containsKey(x)) {
            multiSet.put(x, multiSet.get(x) + 1);
        } else {
            multiSet.put(x, 1);
        }
    }

    static void remove(int x) {
        multiSet.put(x, multiSet.get(x) - 1);
        if (multiSet.get(x) == 0) {
            multiSet.remove(x);
        }
    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        for (int i=0; i<nums1.length; i++){
            add(nums1[i]);
        }
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            Integer higher = multiSet.higherKey(nums2[i]);
            if (higher == null){
                ans[i] = multiSet.firstKey();
                remove(multiSet.firstKey());
            } else {
                ans[i] = higher;
                remove(higher);
            }
        }
        return ans;
    }
}
