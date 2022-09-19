package com.sourav.leetcode.string;

public class FinalValueAfterOPerations {
    public static int finalValueAfterOperations(String[] operations) {
        int curr = 0;
        for (final String op : operations) {
            if (op.charAt(1) == '+') {
                curr++;
            } else {
                curr--;
            }
        }
        return curr;
    }


    public static void main(String[] args) {

    }
}
