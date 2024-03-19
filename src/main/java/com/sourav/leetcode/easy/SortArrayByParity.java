package com.sourav.leetcode.easy;

import java.util.Date;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] % 2 != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            } else {
                i++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        Date date = new Date("NaN");
        System.out.print(date);
    }
}



