package com.sourav.leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int st = 0, ans = 0;
        for (int end = 0; end < nums.length; end++) {
            if (!map.containsKey(nums[end])) {
                map.put(nums[end], 0);
            }
            map.put(nums[end], map.get(nums[end])+1);
            while (map.size() > k) {
                map.put(nums[st], map.get(nums[st])-1);
                if (map.get(nums[st]) == 0){
                    map.remove(nums[st]);
                }
                st++;
            }
            if (map.size() == k) {
                ans += (end - st + 1) - k + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 1));
        System.out.println(subarraysWithKDistinct(new int[]{2,2,1,2,2,2,1,1}, 2));

    }
}
