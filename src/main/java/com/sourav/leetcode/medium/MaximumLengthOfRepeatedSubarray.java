package com.sourav.leetcode.medium;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i=0; i<n1; i++){
            for(int j=0; j<n2;j++){
                if(nums1[i] == nums2[j]){
                    int curr = 0;
                    int k = i;
                    int l = j;
                    while(k<n1 && l<n2 && nums1[k] == nums2[l]){
                        curr++;
                        k++;
                        l++;
                    }
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }
}
