package com.sourav.leetcode.bitManipulation;

public class SubsetXORSum {
    public static int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int b = 0; b < (1 << n); b++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if ((b & (1 << i)) > 0) {
                    curr = curr ^ nums[i];
                }
            }
            sum += curr;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

}
