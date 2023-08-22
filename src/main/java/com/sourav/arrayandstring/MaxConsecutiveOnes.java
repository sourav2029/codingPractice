package com.sourav.arrayandstring;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currMax++;
                ans = Math.max(ans, currMax);
            } else {
                currMax = 0;
            }
        }
        return ans;
    }
}
