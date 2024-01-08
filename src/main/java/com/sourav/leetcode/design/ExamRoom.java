package com.sourav.leetcode.design;

import java.util.TreeSet;

public class ExamRoom {
    int capacity;
    TreeSet<Integer> seats;

    public ExamRoom(int n) {
        capacity = n;
        seats = new TreeSet<>();
    }

    public int seat() {
        int seatNumber = 0;
        if (seats.size() > 0) {
            int dist = seats.first();
            Integer prev = null;
            for (Integer seat : seats) {
                if (prev != null) {
                    int d = (seat - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        seatNumber = prev + d;
                    }
                }
                prev = seat;
            }
            if (capacity - 1 - seats.last() > dist) {
                seatNumber = capacity - 1;
            }
        }
        seats.add(seatNumber);
        return seatNumber;

    }

    public void leave(int p) {
        seats.remove(p);
    }
}
