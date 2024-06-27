package com.sourav.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AllOne {
    Map<String, Integer> freq;
    int min, max;
    String minKey, maxKey;

    public AllOne() {
        freq = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void inc(String key) {
        freq.put(key, freq.getOrDefault(key, 0) + 1);
        int currVal = freq.get(key);
        if (minKey.equals(key)) {
            min = currVal;
        }
        if (currVal < min) {
            min = currVal;
            minKey = key;
        }
        if (maxKey.equals(key)) {
            max = currVal;
        }
        if (currVal > max) {
            max = currVal;
            maxKey = key;
        }

    }

    public void dec(String key) {
        freq.put(key, freq.getOrDefault(key, 1) - 1);
        int currVal = freq.get(key);
        if (minKey.equals(key)) {
            min = currVal;
        }
        if (currVal < min) {
            min = currVal;
            minKey = key;
        }
        if (maxKey.equals(key)) {
            max = currVal;
        }
        if (currVal > max) {
            max = currVal;
            maxKey = key;
        }
    }

    public String getMaxKey() {
        return maxKey;
    }

    public String getMinKey() {
        return minKey;
    }

}
