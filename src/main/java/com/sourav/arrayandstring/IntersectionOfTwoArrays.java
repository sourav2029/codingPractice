package com.sourav.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 0; i < n1 && j < n2; ) {
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
