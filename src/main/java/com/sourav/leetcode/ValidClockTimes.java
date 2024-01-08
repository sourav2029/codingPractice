package com.sourav.leetcode;

public class ValidClockTimes {
    public int countTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String min = split[1];
        int hourChoices = getHourChoices(hour);
        int minChoices = getMinuteChoices(min);
        return hourChoices * minChoices;
    }

    public int getHourChoices(String hour) {
        if (hour.charAt(0) == '?') {
            if (hour.charAt(1) == '?') {
                return 24;
            } else if (hour.charAt(1) > 3) {
                return 2;
            } else {
                return 3;
            }
        } else {
            if (hour.charAt(1) != '?') {
                return 1;
            } else if (hour.charAt(0) == '2') {
                return 4;
            } else {
                return 10;
            }
        }
    }

    public int getMinuteChoices(String min) {
        int res = 1;
        if (min.charAt(0) == '?') {
            res *= 6;
        }
        if (min.charAt(1) == '?') {
            res *= 10;
        }
        return res;
    }
}
