package com.sourav.arrayandstring;

//https://leetcode.com/problems/strong-password-checker-ii/description/
public class PasswordChecker {
    public boolean strongPasswordCheckerII(String password) {
        char[] arr = password.toCharArray();
        int len = arr.length;
        if (len < 8) {
            return false;
        }
        int lowercaseCount = 0;
        int uppercaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        for (int i = 0; i < len; i++) {
//            clean way to check if a char is lowercase, uppercase or digit, also special case can be handled with indexOf function
            if (arr[i] >= 'a' && arr[i] <= 'z')
                lowercaseCount++;
            if (arr[i] >= 'A' && arr[i] <= 'Z')
                uppercaseCount++;
            if (arr[i] >= '0' && arr[i] <= '9')
                digitCount++;
            if (isSpecialChar(arr[i]))
                specialCharCount++;
            if (i > 0 && arr[i] == arr[i - 1]) {
                return false;
            }
        }
        if (lowercaseCount == 0 || uppercaseCount == 0 || digitCount == 0 || specialCharCount == 0)
            return false;
        return true;

    }

    public boolean isSpecialChar(char c) {
        if ("!@#$%^&*()-+".indexOf(c) != -1)
            return true;
        return false;
    }
}
