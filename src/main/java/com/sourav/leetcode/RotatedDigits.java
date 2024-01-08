package com.sourav.leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }


    public static boolean isValid(int n) {
        boolean isValid = false;
        while (n > 0) {
            int rem = n % 10;
                switch (rem) {
                case 2:
                case 5:
                case 6:
                case 9:
                    isValid = true;
                    break;
                case 3:
                case 4:
                case 7:
                    return false;
            }
            n /= 10;
        }
        return isValid;
    }


    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
        System.out.println(rotatedDigits(2));
        System.out.println(rotatedDigits(1));

    }
}
