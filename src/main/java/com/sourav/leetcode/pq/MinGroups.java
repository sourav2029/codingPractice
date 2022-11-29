package com.sourav.leetcode.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
public class MinGroups {
    public class Pair implements Comparable<Pair> {
        int val;
        boolean isStart;

        Pair(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }

        public int compareTo(Pair o) {
            int comp = Integer.compare(val, o.val);
            if (comp == 0) {
                if (isStart) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return comp;
        }
    }

    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        Pair[] times = new Pair[2 * n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            times[count++] = new Pair(intervals[i][0], true);
            times[count++] = new Pair(intervals[i][1], false);
        }
        Arrays.sort(times);
        count = 0;
        int ans = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i].isStart) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public class Pair2 implements Comparable<Pair2> {
        int st;
        int end;

        public Pair2(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair2 o) {
            return Integer.compare(st, o.st);
        }
    }

    public int minGroups2(int[][] intervals) {
        int n = intervals.length;
        Pair2[] times = new Pair2[n];
        for (int i = 0; i < n; i++) {
            times[i] = new Pair2(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(times);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < times.length; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() < times[i].st) {
                minHeap.poll();
            }
            minHeap.offer(times[i].end);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] interval = {{441459, 446342}, {801308, 840640}, {871890, 963447}, {228525, 336985}, {807945, 946787}, {479815, 507766}, {693292, 944029}, {751962, 821744}};
        MinGroups minGroups = new MinGroups();
        System.out.println(minGroups.minGroups2(interval));
    }
}
