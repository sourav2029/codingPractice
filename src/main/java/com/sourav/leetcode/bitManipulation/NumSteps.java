package com.sourav.leetcode.bitManipulation;

public class NumSteps {
    public static int numSteps(String s) {
        int carry = 0;
        int ans = 0;
        int len = s.length();
        for (int i = len - 1; i > 0; i--) {
            int curr = (s.charAt(i) - '0') + carry;
            if (curr == 1) {
                ans++;
                carry = 1;
            }
            ans++;
        }
        if (carry == 1) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
    }
}
