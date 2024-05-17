package com.sourav.binarySearch;

import java.util.Arrays;

public class Candies {
    static int MAX_LENGTH = 100000;
    static int MAX_VALUE = 10000000;

    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        long max = sum / k;
        if (max == 0) {
            return 0;
        }
        long min = 1;
        long ans = 0;
        while (min <= max) {
            long mid = min + (max - min) / 2;
            if (noOfChildren(candies, mid) >= k) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return (int) ans;
    }

    public static long noOfChildren(int[] candies, long numOfCandiesForEach) {
        long children = 0;
        for (int candy : candies) {
            children += candy / numOfCandiesForEach;
        }
        return children;
    }

    public static void main(String[] args) {
        System.out.println();
        int[] arr = new int[MAX_LENGTH];
        Arrays.fill(arr, MAX_VALUE);
        System.out.println(maximumCandies(arr, 1));
    }
}
