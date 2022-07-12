package com.sourav.graph;


public class StrongPasswordChecker {
    public static void main(String[] args) {
        System.out.println(isStrongPassword("aaA123"));
    }

    public static boolean isStrongPassword(String password) {
        char[] passArray = password.toCharArray();
        if (!(passArray.length >= 6 && passArray.length <= 20)) {
            return false;
        }
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;

        for (int i = 0; i < passArray.length / 3; i++) {
            int j = 3 * i;
            if (passArray[j] == passArray[j + 1]) {
                if (passArray[j] == passArray[j + 2]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < passArray.length; i++) {
            if (passArray[i] >= 'A' && passArray[i] <= 'Z') {
                containsUpperCase = true;
            }
            if (passArray[i] >= 'a' && passArray[i] <= 'z') {
                containsLowerCase = true;
            }
            if (passArray[i] >= '0' && passArray[i] <= '9') {
                containsDigit = true;
            }

        }

        if (!(containsDigit && containsLowerCase && containsUpperCase)) {
            return false;
        }
        return true;
    }
}
