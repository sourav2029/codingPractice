package com.sourav.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountNumbers {


    public static boolean hasUniqueDigits(int num) {
        boolean[] seen = new boolean[10];
        while (num > 0) {
            int rem = num % 10;
            if (seen[rem]) {
                return false;
            }
            seen[rem] = true;
            num /= 10;
        }
        return true;
    }


    static void countNumbers(List<List<Integer>> arr) {
        int size = 1000001;
        int[] cache = new int[size];
        int count = 0;
        for (int i = 1; i < size; i++) {
            if (hasUniqueDigits(i)) {
                count++;
            }
            cache[i] = count;
        }
        for (List<Integer> pair : arr) {
            int st = pair.get(0);
            int end = pair.get(1);
            System.out.println(cache[end] - cache[st - 1]);
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(34, 84);
        List<List<Integer>> in = Arrays.asList(nums);
        countNumbers(in);
        nums = Arrays.asList(34, 84);
        in = Arrays.asList(nums);
        countNumbers(in);
    }
}
