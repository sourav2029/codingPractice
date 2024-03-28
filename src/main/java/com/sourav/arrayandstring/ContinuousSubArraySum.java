package com.sourav.arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> mapOfModToIndex = new HashMap<>();
        mapOfModToIndex.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (mapOfModToIndex.containsKey(rem)) {
                int prevIndex = mapOfModToIndex.get(rem);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                mapOfModToIndex.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }


}

/*
Test Cases
[23,2,6,4,7]
13
[23,2,4,6,6]
7
[6,2,0]
5
[1,0]
2
[0,0]
1
[6,2,25]
5
[0,1,0]
1
[0,0,2]
1
 */
