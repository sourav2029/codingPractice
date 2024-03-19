package com.sourav.leetcode.easy.easy;

import java.util.HashMap;
import java.util.Map;

public class ReverseVowels {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels[c] = true;
        }
        int i = 0;
        int len = s.length();
        int j = len - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            while(i<j && !vowels[arr[i]]){
                i++;
            }
            while(i<j && !vowels[arr[j]]){
                j--;
            }
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
        return new String(arr);
    }


}
