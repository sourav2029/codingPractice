//package com.sourav.leetcode.medium;
//
//import java.util.*;
//
//public class LetterCombinationOfPhone {
//    class Solution {
//        Map<Integer, List<Character>> map = new HashMap<>();
//
//        public List<String> letterCombinations(String digits) {
//            List<String> ans = new ArrayList<>();
//            int start = 'a';
//            for (int i = 2; i <= 9; i++) {
//                if (i == 7 || i == 9) {
//                    map.put(i, new ArrayList<>(Arrays.asList((char) start++, (char) start++, (char) start++, (char) start++)));
//                } else {
//                    map.put(i, new ArrayList<>(Arrays.asList((char) start++, (char) start++, (char) start++)));
//                }
//            }
//
//        }
//
//
//        public void process(List<String> ans, List<>, int index) {
//            if (index == digits.length) {
//                return;
//            }
//            char c = d
//        }
//    }
//}
