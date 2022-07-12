package com.sourav.leetcode.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
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

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return  (minHeap.peek() * 1.0 + maxHeap.peek() * 1.0) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        return maxHeap.peek();
    }
}
