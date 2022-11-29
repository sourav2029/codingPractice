package com.sourav.leetcode.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for (int num : nums) {
            pq.add(num);
        }
        int first = pq.poll();
        int second = pq.poll();
        return (first-1)*(second-1);
    }
}
