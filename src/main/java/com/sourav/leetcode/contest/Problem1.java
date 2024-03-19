package com.sourav.leetcode.contest;

import java.util.Arrays;

public class Problem1 {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lower = lowerBound(nums,k);
        if(lower == -1){
            return nums.length;
        }
        return nums.length-lower;
    }

    public int lowerBound(int[] nums, int target){
        int end = nums.length;
        int st= 0;
        int res = -1;
        while(st<= end){
            int mid = st + (end-st)/2;
            if(nums[mid]==target){
                res = mid;
                end = mid-1;
            } else if (nums[mid] > target){
                end = mid-1;
            } else {
                st = mid+1;
            }
        }
        return res;
    }
}
