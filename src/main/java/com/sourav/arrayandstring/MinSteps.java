package com.sourav.arrayandstring;

public class MinSteps {
    public static int minSteps(String s, String t) {
        int[] count = new int[250];
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        int ans = 0;
        if (n > m) {
            ans = n - m;
        }
        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i)] != 0) {
                count[t.charAt(i)]--;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSteps("Sourav", "prem"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
        System.out.println(minSteps("aba", "bab"));

    }
}
