package com.sourav.leetcode.prefixSum;

public class LongestMountain {
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1; i<n;i++){
            if(arr[i] > arr[i-1]){
                left[i] = left[i-1]+1;
            } else {
                left[i] = 0;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(arr[i] > arr[i+1]){
                right[i] = right[i+1] + 1;
            } else {
                right[i] = 0;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(left[i] != 0 && right[i] != 0){
                ans = Math.max(ans , left[i] + right[i] + 1);
            }
        }
        return ans == 1 ? 0: ans;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(longestMountain(new int[]{2,2,2}));
        System.out.println(longestMountain(new int[]{2,4,2}));
        System.out.println(longestMountain(new int[]{0,1,2,3,4,5,6,7,8,9}));
    }
}
