package com.sourav.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int curr = -nums[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                if (nums[start] + nums[end] == curr) {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                }
                start++;
                end--;
                while (start < n && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (end > 0 && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
        }
        return ans;
    }
}
