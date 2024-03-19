package com.sourav.twopointer;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-common-value/description
public class GetCommon {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        for(int num : nums2){
            if(set.contains(num)){
                return num;
            }
        }
        return -1;
    }
}
