package com.sourav.arrayandstring;

import java.util.*;

public class MeetingRoom3 {
    public class Meeting implements Comparable<Meeting> {
        int st;
        int end;

        public Meeting(int st, int end){
            this.st = st;
            this.end  = end;
        }

        public int compareTo(Meeting o){
            return Integer.compare(this.end, o.end);
        }
    }

//    public int mostBooked(int n, int[][] meetings) {
//        int len = meetings.length;
//        Meeting[] meets = new Meeting[len];
//        for(int i=0; i<len; i++){
//            meets[i] = new Meeting(meetings[i][0], meetings[i][1]);
//        }
//        int[] count = new int[n];
//        Map<Integer, Meeting> map = new HashMap<>();
//        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
//        PriorityQueue<Meeting> q = new PriorityQueue<>();
//        for(int i=0; i<len; i++){
//
//        }
//    }
}
