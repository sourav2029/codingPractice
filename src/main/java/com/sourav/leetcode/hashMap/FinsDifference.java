package com.sourav.leetcode.hashMap;

import org.checkerframework.checker.units.qual.A;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class FinsDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>(set1);
        List<Integer> ans2 = new ArrayList<>(set2);

        ans1.removeAll(set2);
        ans2.removeAll(set1);

        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
