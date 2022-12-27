package com.sourav.binarySearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return searchHelper(0, n - 1, nums, target);
    }

    public int searchHelper(int start, int end, int[] nums, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return searchHelper(start, end - 1, nums, target);
        } else if (nums[mid] < target) {
            return searchHelper(mid + 1, end, nums, target);
        } else {
            return mid;
        }
    }
}
