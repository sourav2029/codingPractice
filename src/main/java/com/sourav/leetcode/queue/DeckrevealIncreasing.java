package com.sourav.leetcode.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeckrevealIncreasing {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        Arrays.sort(deck);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        return res;
    }
}
