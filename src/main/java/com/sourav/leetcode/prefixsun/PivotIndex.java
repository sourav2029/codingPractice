package com.sourav.leetcode.prefixsun;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] rightSum = new int[len];
        rightSum[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < len - 1; i++) {
            if (leftSum == rightSum[i + 1]) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        if(leftSum == 0){
            return len -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivotIndex(new int[]{-1, 1, 3}));

    }
}
