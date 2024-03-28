package com.sourav.arrayandstring;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubArraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        int[] map = new int[k];
        map[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = (sum %k +k)%k;
            ans += map[rem];
            map[rem]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{-1,-9,-4,0}, 9));
    }

}

/* Test Cases
[4,5,0,-2,-3,1]
10
[5]
9
[0,0,0]
3
[3,3,0]
6
[-1,2,9]
2
[-5, 17, 26]
12
[-1,-9,-4,0]
9
 */
