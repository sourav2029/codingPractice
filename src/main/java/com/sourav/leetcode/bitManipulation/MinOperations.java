package com.sourav.leetcode.bitManipulation;

public class MinOperations {
    public static  int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }

        int ans =0;
        while(xor> 0 || k>0 ){
            int xorBit = xor & 1;
            int kBit = k & 1;
            if(xorBit != kBit){
                ans++;
            }
            xor =xor>>1;
            k = k>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2,1,3,4}, 1));
        System.out.println(minOperations(new int[]{2,1,3,4}, 6));

    }
}
