package com.sourav.leetcode.contest;

import java.util.PriorityQueue;

public class Problem2 {
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long num : nums){
            pq.add(num);
        }
        int res = 0;
        while(pq.size() >= 2) {
            long min = pq.poll();
            long max = pq.poll();
            if(min >= k){
                return res;
            }
            res++;
            pq.add(min*2+max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1000000000,999999999,1000000000,999999999,1000000000,999999999
        ,1000000000}, 1000000000));
    }
}
