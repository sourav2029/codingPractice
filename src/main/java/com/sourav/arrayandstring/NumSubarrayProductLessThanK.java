package com.sourav.arrayandstring;

//https://leetcode.com/problems/subarray-product-less-than-k/
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, st = 0, prod =1;
        for (int end = 0; end < nums.length; end++) {
            prod *= nums[end];
            while (prod >= k && st <= end)
                prod /= nums[st++];
            ans += (end - st) + 1;
        }
        return ans;
    }
}
