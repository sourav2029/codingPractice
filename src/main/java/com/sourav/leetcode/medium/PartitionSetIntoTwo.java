package com.sourav.leetcode.medium;

import java.util.Arrays;

public class PartitionSetIntoTwo {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        boolean[] sumArray = new boolean[target + 1];
        sumArray[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                sumArray[j] |= sumArray[j - nums[i]];
            }
        }
        return sumArray[target - 1];

    }


    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2, 2, 1, 1}));
        System.out.println(canPartition(new int[]{5, 5, 11, 1}));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }
}
