package com.sourav.twopointer;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int count = 0;
        while(i<n){
            if(nums[i] != 0){
                i++;
                j++;
            } else {
                count++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,0,2,3,4};
        moveZeroes(nums);
    }


}
