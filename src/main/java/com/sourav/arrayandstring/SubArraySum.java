package com.sourav.arrayandstring;


import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    //    Brute Force
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int st = 0; st < nums.length; st++) {
            int sum = 0;
            for (int e = st; e < nums.length; e++) {
                sum += nums[e];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    //
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int st = 0; st < nums.length; st++) {
            sum += nums[st];
            if(map.containsKey(sum)){
                ans++;
            } else {
                map.put(k - sum, st);
            }
        }
        return ans;
    }
}
