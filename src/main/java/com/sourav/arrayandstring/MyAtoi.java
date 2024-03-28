package com.sourav.arrayandstring;

public class MyAtoi {
    public static int myAtoi(String s) {
        long res = 0;
        int sign = 1;
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length && arr[i] == ' ') {
            i++;
        }

        if (i < arr.length && arr[i] == '-') {
            sign = -1;
            i++;
        } else if (i < arr.length && arr[i] == '+') {
            i++;
        }
        while (i < arr.length && Character.isDigit(arr[i])) {
            res = res * 10 + arr[i] - '0';
            if (res * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) res * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("   -21474836499"));
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("   2147483647"));
        System.out.println(myAtoi("   -2147483647"));
        System.out.println(myAtoi("   -2147483649193123"));

    }
}
