package com.sourav.arrayandstring;

public class ZeroFilledSubArrays {
    public static long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int consecutiveZeroCount = 0;
            while (i < n && nums[i] == 0) {
                consecutiveZeroCount++;
                zeroCount += consecutiveZeroCount;
                i++;
            }
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{0, 0, 0,2,6,8,0, 0,0}));
    }
}
