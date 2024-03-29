package com.sourav.leetcode;

import java.util.Arrays;

public class MaxDistanceToClosest {
    public static int maxDistToClosest(int[] seats) {
        int maxConsecutiveZeroes = 0;
        int len = seats.length;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) {
                int start = i;
                int end = i;
                while (end < len && seats[end] == 0) {
                    end++;
                }
                maxConsecutiveZeroes = Math.max(maxConsecutiveZeroes, end - start + 1);
                i = end;
            }
        }
        return (int) Math.ceil((maxConsecutiveZeroes * 1.0) / 2);
    }

    public static int maxDistToClosest2(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i-1] + 1;
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N-1) right[i] = right[i+1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest2(new int[]{1,0,0,0}));
    }

}
