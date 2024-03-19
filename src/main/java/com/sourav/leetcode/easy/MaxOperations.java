package com.sourav.leetcode.easy;

import java.util.Arrays;

public class MaxOperations {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                res++;
                i++;
                j--;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,2,3,4,3}, 6));
    }
}
