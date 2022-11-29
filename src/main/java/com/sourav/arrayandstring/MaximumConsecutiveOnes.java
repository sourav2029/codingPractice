package com.sourav.arrayandstring;

public class MaximumConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int ans = 0;
        int zeroCount = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[j] == 0) {
                    zeroCount--;
                }
                j++;
            }
            i++;
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
