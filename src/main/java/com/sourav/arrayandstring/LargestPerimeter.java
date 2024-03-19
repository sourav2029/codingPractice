package com.sourav.arrayandstring;

import java.util.Arrays;

public class LargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ans = -1;
        int n = nums.length;
        long sum = nums[0];
        for (int i = 1; i < n - 1; i++) {
            sum = nums[i] + sum;
            if (nums[i + 1] < sum) {
                ans = Math.max(ans, sum + nums[i + 1]);
            }
        }
        return ans;

    }
}
