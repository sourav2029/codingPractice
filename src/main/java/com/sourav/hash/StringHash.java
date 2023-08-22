package com.sourav.hash;

public class StringHash {

//    The compute hash function assumes the input to be lower case alphabet letters.
    public static long computeHash(String s) {
        final int p = 31;
        final int m = 1000000000 + 9;
        long hash = 0;
        long pow = 1;
        for (char c : s.toCharArray()) {
            int curr = c - 'a' + 1;
            hash = (hash + curr * pow) % m;
            pow = (pow * p) % m;
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(computeHash("souravpremisme"));
        System.out.println(computeHash("souravprem"));

    }
}
