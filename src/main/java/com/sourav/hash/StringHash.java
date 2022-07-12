package com.sourav.hash;

public class StringHash {

    public static long computeHash(String s) {
        final int p = 31;
        final int m = 1000000009;
        long hash = 0;
        long pow = 1;
        for (char c : s.toCharArray()){
            hash += ((c-'a' + 1)*pow)%m;
            pow = (pow*p)%m;
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(computeHash("Sourav Prem is me!!!"));
        return;
    }
}
