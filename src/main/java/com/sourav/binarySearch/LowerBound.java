package com.sourav.binarySearch;
//https://leetcode.com/problems/search-insert-position/
public class LowerBound {
    public int searchInsert(int[] nums, int target) {
        int st = 0;
        int end = nums.length-1;
        int res = 0;
        while(st<= end){
            int mid = st + (end-st)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                res = mid+1;
                st = mid+1;
            } else {
                end = mid-1;
            }
        }
        return res;
    }
}
