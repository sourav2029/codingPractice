package com.sourav.leetcode.design;

import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo{

    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    List<Event> events;

    public MyCalendarTwo() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int count = 0;
        for (Event event : events) {
            if (event.start >= end) {
                continue;
            }
            if (event.end <= start) {
                continue;
            }
            count++;
        }
        if (count > 2) {
            return false;
        }
        events.add(new Event(start, end));
        return true;
    }
}
