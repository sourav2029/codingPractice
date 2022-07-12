package com.sourav.leetcode.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void add(int num){
        if (minHeap.size() > maxHeap.size()){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(minHeap.peek() < maxHeap.peek()){
            int temp = minHeap.poll();
            maxHeap.add(temp);
            minHeap.add(maxHeap.poll());
        }
    }

    public static void delete(int num){
        if (num > minHeap.peek()){
            minHeap.remove(num);
        } else {
            maxHeap.remove(num);
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            double ans = (minHeap.peek() * 1.0 + maxHeap.peek() * 1.0) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        return maxHeap.peek();
    }


    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] ans  = new double[len-k+1];
        int st = 0;
        for (int i=0; i<k;i++){
            add(nums[i]);
        }
        ans[st++] = findMedian();
        for (int i=k; i<len;i++){
            add(nums[i]);
            delete(nums[i-k]);
            ans[st++] = findMedian();
        }
        return ans;
    }
}
