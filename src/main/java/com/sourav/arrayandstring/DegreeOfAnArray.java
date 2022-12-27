package com.sourav.arrayandstring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(),
                left = new HashMap<>(), right = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            right.put(nums[i],i);
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }

        int degree = Collections.max(count.values());
        System.out.println(degree);
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(count.get(nums[i]) == degree){
                ans = Math.min(ans, right.get(nums[i]) - left.get(nums[i])+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,4,3,1,2,2}));
    }
}
