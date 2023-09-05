package com.sourav.leetcode.SlidingWindow;

public class LongestOnes {
    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int max = 0;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1}, 1));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1}, 0));
        System.out.println(longestOnes(new int[]{0, 0}, 0));

    }
}
