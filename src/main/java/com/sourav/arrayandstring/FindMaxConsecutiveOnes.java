package com.sourav.arrayandstring;

public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curr++;
            } else {
                curr = 0;
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
