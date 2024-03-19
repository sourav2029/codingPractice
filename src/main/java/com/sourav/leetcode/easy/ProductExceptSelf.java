package com.sourav.leetcode.easy;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int pre = 1, post = 1;
        for (int i = 0; i < len; i++) {
            res[i] = pre;
            pre = pre * nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * post;
            post = post * nums[i];
        }
        return res;
    }
}
