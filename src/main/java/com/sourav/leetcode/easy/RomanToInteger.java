package com.sourav.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static Map<Character, Integer> valueMap;
    static {
        valueMap = new HashMap<>();
        valueMap.put('I',1);
        valueMap.put('X', 10);
        valueMap.put('V', 5);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);
    }

    public static int romanToInt(String s){
        Integer ans = 0;
        for (int i=0; i<s.length(); ){
            char c= s.charAt(i);
            if (c == 'I'){
                if (i+1 < s.length() && s.charAt(i+1) == 'V'){
                    ans += 4;
                    i+= 2;
                } else if (i+1 < s.length() && s.charAt(i+1) == 'X'){
                    ans += 9;
                    i+=2;
                } else {
                    ans++;
                    i++;
                }
            } else if (c == 'X'){
                if (i+1 < s.length() && s.charAt(i+1) == 'L'){
                    ans += 40;
                    i+= 2;
                } else if (i+1 < s.length() && s.charAt(i+1) == 'C'){
                    ans += 90;
                    i+= 2;
                } else {
                    ans += 10;
                    i++;
                }
            } else if (c== 'C'){
                if (i+1 < s.length() && s.charAt(i+1) == 'D'){
                    ans += 400;
                    i+= 2;
                } else if (i+1 < s.length() && s.charAt(i+1) == 'M'){
                    ans += 900;
                    i+= 2;
                } else {
                    ans += 100;
                    i++;
                }
            } else {
                ans += valueMap.get(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XVII"));
    }
}
