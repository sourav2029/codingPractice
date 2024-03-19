package com.sourav.arrayandstring;

public class CheckDistances {
    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < distance.length; i++) {
            char c = (char) (i + 'a');
            int dist = findDistance(s, c);
            if (dist != -1 && dist != distance[i]) {
                return false;
            }
        }
        return true;
    }

    public int findDistance(String s, char c) {
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                if (prev != -1) {
                    return i - prev - 1;
                } else {
                    prev = i;
                }
            }
        }
        return -1;
    }
}
