package com.sourav.stack;

import java.util.Stack;

public class RemoveKDigit {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char current = num.charAt(0);
        stack.push(current);
        for (int i = 1; i < num.length(); i++) {
            current = num.charAt(i);
            while (k > 0 && !stack.isEmpty()  && stack.peek() > current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()){
            return "0";
        }

        char[] arr = new char[stack.size()];
        int index = stack.size() - 1;
        int length = index+1;
        while(stack.size() > 0){
            arr[index--] = stack.pop();
        }
        int leadingZeroes = 0;
        for (; leadingZeroes <= index; ) {
            if (arr[leadingZeroes] == '0') {
                leadingZeroes++;
            } else {
                break;
            }
        }
        if (leadingZeroes == length){
            return "0";
        }
        String res =  String.copyValueOf(arr, leadingZeroes, length-leadingZeroes);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("9", 1));
    }


}
