package com.sourav.arrayandstring;

import java.util.Arrays;
import java.util.Map;

public class MeetingRooms {
    public static class Meeting implements Comparable<Meeting> {
        int time;
        boolean isStart;

        @Override
        public int compareTo(Meeting o) {
            if (this.time != o.time) {
                return Integer.compare(this.time, o.time);
            }
            if (this.isStart)
                return 1;
            else
                return -1;
        }

        public Meeting(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Meeting[] meetings = new Meeting[2 * n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(intervals[i][0], true);
            meetings[n + i] = new Meeting(intervals[i][1], false);
        }
        int rooms = 0;
        int ans = 0;
        Arrays.sort(meetings);
        for (Meeting meeting : meetings) {
            if (meeting.isStart) {
                rooms++;
                ans = Math.max(ans, rooms);
            } else {
                rooms--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}, {3, 8}, {4, 12}}));
        System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(minMeetingRooms(new int[][]{{13,15},{1,13}}));
    }
}
