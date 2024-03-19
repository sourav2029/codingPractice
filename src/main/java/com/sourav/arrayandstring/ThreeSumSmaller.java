package com.sourav.arrayandstring;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = nums[i] + nums[j];
                if(sum>= target && nums[j]> 0){
                    break;
                }
                for(int k=j+1; k<n; k++){
                    if (sum + nums[k] < target){
                        ans++;
                    } else if (nums[j]> 0){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
