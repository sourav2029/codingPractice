package com.sourav.leetcode.easy.easy;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int min = nums[0];
        int secondMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > secondMin) {
                return true;
            }
            if (nums[i] > min) {
                secondMin = nums[i];
            } else {
                min = nums[i];
            }
        }
        return false;
    }
}
