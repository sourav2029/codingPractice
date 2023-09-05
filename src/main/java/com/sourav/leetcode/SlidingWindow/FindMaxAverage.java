package com.sourav.leetcode.SlidingWindow;

public class FindMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0;
        int globalMax = 0;
        while (j < k) {
            globalMax += nums[j++];
        }
        int currSum = globalMax;
        while (j < nums.length) {
            currSum += (nums[j] - nums[j - k]);
            globalMax = Math.max(currSum, globalMax);
            j++;
        }
        return (double) globalMax / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 3}, 2));
    }
}
