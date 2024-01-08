package com.sourav.leetcode.design;

import java.util.HashMap;
import java.util.Map;

class Logger {
    Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int lastTimestamp = map.get(message);
            if (timestamp >= lastTimestamp + 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
        map.put(message, timestamp);
        return true;
    }
}