package com.sourav.arrayandstring;

import lombok.ToString;

import java.util.Arrays;

@ToString
public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0]*nums[1]* nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1,-2,-3,-4}));
    }
}
