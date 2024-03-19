package com.sourav.leetcode;

public class MinimumDifference {
    public static int minimumDifference(int[] nums) {
        return (int) minDiffHelper(0, nums, nums.length, 0, 0, 0, 0);
    }

    public static long minDiffHelper(int index, int[] nums, int n, int  sum1, int sum2, int len1, int len2) {
        if (index == n) {
            if (len1 != len2) {
                return Integer.MAX_VALUE;
            }
            return Math.abs(sum1-sum2);
        }
        long a = minDiffHelper(index + 1, nums, n, sum1 + nums[index], sum2, len1 + 1, len2);
        long b = minDiffHelper(index + 1, nums, n, sum1, sum2 + nums[index], len1, len2 + 1);
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694
}));
    }
}
