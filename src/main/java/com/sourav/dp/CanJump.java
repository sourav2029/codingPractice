package com.sourav.dp;

public class CanJump {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int curr = nums[0];
        for (int i = 1; i <= curr; i++) {
            if (curr >= n - 1) {
                return true;
            }
            curr = Math.max(curr, nums[i] + i);
        }
        if (curr >= n - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
