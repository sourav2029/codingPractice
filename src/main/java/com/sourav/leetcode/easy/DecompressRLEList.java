package com.sourav.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DecompressRLEList {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                list.add(val);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int elem : list) {
            res[i++] = elem;
        }
        return res;
    }
}
