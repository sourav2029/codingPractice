package com.sourav.arrayandstring;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/meeting-rooms/description/
public class MeetingRoom {
//    sorts the meeting in ascending order of start time.
//    Integer.compare(this.start, o.start)
//    To sort in descending
    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        @Override
        public int compareTo(Meeting o) {
            return Integer.compare(this.start, o.start);
        }

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][]{{0,30},{15,20},{5,10}}));
    }

}
