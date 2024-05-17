package com.sourav.graph.bfs;

import java.util.*;

public class OpenLock {
    public static int openLock(String[] deadends, String target) {
        Map<String, Boolean> visited = new HashMap<>();
        for (String s : deadends) {
            visited.put(s, true);
        }
        if (visited.containsKey("0000")) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.put("0000", true);
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return dist;
                }
                char[] arr = curr.toCharArray();
                for (int k = 0; k < 4; k++) {
                    char c = arr[k];
                    arr[k] = c == '9' ? '0' : (char) (c + 1);
                    String next = new String(arr);
                    if (next.equals(target)) {
                        return dist + 1;
                    }
                    if (!visited.containsKey(next)) {
                        visited.put(next, true);
                        q.add(next);
                    }
                    arr[k] = c == '0' ? '9' : (char) (c - 1);
                    next = new String(arr);
                    if (next.equals(target)) {
                        return dist + 1;
                    }
                    if (!visited.containsKey(next)) {
                        visited.put(next, true);
                        q.add(next);
                    }
                    arr[k] = c;
                }
            }
            dist++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}

