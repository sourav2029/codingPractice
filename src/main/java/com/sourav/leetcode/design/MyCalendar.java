package com.sourav.leetcode.design;

import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer, Integer> bookings;

    public MyCalendar() {
        bookings = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = bookings.floorKey(start);
        Integer next = bookings.ceilingKey(start);
        if (prev != null && bookings.get(prev) > start) {
            return false;
        }
        if (next != null && next < end) {
            return false;
        }
        bookings.put(start, end);
        return true;
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
