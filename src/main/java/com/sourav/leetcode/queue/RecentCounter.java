package com.sourav.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    final Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty()) {
            int front = queue.peek();
            if (t - front > 3000) {
                queue.poll();
            } else {
                break;
            }
        }
        return queue.size();
    }
}
