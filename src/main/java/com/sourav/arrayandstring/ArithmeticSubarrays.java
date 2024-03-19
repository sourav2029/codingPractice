package com.sourav.arrayandstring;

import java.util.*;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int s = l[i];
            int e = r[i];
            int[] arr = new int[e - s + 1];
            for (int j = 0; j < e - s + 1; j++) {
                arr[j] = nums[s + j];
            }
            res.add(isArithmetic2(arr));
        }
        return res;
    }


    public boolean isArithmetic(int[] nums) {
        Arrays.sort(nums);
        int d = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != d) {
                return false;
            }
        }
        return true;
    }


    public boolean isArithmetic2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
            set.add(num);
        }

        if ((max - min) % (nums.length - 1) != 0) {
            return false;
        }

        int diff = (max-min)/(nums.length-1);
        int curr = min + diff;

        while(curr < max){
            if(!set.contains(curr)){
                return false;
            }
            curr += diff;
        }
        return true;
    }
}
