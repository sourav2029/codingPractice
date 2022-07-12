package com.sourav.arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class CustomSort {
    public static String customSortString(String order, String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (count[c - 'a'] > 0) {
                int toAdd = count[c - 'a'];
                while (toAdd > 0) {
                    ans.append(c);
                    toAdd--;
                }
                count[c - 'a'] = 0;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                int toAdd = count[i];
                while (toAdd > 0) {
                    ans.append((char) ('a' + i));
                    toAdd--;
                }
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String res = customSortString("dfe", "ffenfefbhefbiuf");
        System.out.println(res);
    }


}
