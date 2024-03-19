package com.sourav.leetcode.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int indexWithoutZero = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[indexWithoutZero++] = nums[i];
        }
        while (indexWithoutZero < len) {
            nums[indexWithoutZero++] = 0;
        }
    }
}
