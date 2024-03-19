package com.sourav.leetcode.easy;

public class ToLowerCase {
    public static String toLowerCase(String str){
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()){
            if (Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
