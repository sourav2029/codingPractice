package com.sourav.leetcode.easy.easy;

public class MaxArea {
    public static int maxArea(int[] height) {
        int globalMax = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int indexDiff = j - i;
            int currMax;
            if (height[i] < height[j]) {
                currMax = indexDiff * height[i];
                i++;
            } else {
                currMax = indexDiff * height[j];
                j--;
            }
            if (currMax > globalMax) {
                globalMax = currMax;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
